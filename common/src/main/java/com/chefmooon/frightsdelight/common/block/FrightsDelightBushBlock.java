package com.chefmooon.frightsdelight.common.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FrightsDelightBushBlock extends BushBlock implements BonemealableBlock {
    private static final float HURT_SPEED_THRESHOLD = 0.003F;
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 8.0, 13.0);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    public static final BooleanProperty GROW_CONDITION = BooleanProperty.create("grow_condition");
    public static final MapCodec<FrightsDelightBushBlock> CODEC = simpleCodec(FrightsDelightBushBlock::new);
    public FrightsDelightBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(GROW_CONDITION, Boolean.FALSE).setValue(AGE, 0);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if ((Integer)state.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return (Integer)state.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(state, level, pos, context);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return (Integer)state.getValue(AGE) < 3;
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(state, new Vec3(0.800000011920929, 0.75, 0.800000011920929));
            if (!level.isClientSide && (Integer)state.getValue(AGE) > 0 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d = Math.abs(entity.getX() - entity.xOld);
                double e = Math.abs(entity.getZ() - entity.zOld);
                if (d >= HURT_SPEED_THRESHOLD || e >= HURT_SPEED_THRESHOLD) {
                    entity.hurt(level.damageSources().sweetBerryBush(), 1.0F);  // TODO: custom damage source here?
                }
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.SOUL_SPEED_BLOCKS);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(AGE, GROW_CONDITION);
    }

    public static boolean hasGrowthCondition(LevelAccessor level, BlockPos pos, int range, TagKey<Block> growCondition) {
        for (BlockPos blockPos : BlockPos.betweenClosed(BlockPos.of(BlockPos.offset(pos.asLong(), -range, -1, -range)),
                BlockPos.of(BlockPos.offset(pos.asLong(), range, 1, range)))) {
            if (level.getBlockState(blockPos).is(growCondition)) {
                return true;
            }
        }
        return false;
    }

    // todo - test this change more before release, LevelAccessor was ServerLevel
    public void updateGrowthCondition(BlockState state, LevelAccessor level, BlockPos pos, int range, TagKey<Block> growCondition, boolean oldCondition) {
        boolean newCondition = hasGrowthCondition(level, pos, range, growCondition);
        if (newCondition != oldCondition) {
            level.setBlock(pos, (BlockState)state.setValue(GROW_CONDITION, newCondition), 2);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return (Integer)state.getValue(AGE) < 3;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if (state.getValue(GROW_CONDITION)) level.setBlock(pos, (BlockState)state.setValue(AGE, Math.min(3, (Integer)state.getValue(AGE) + 1)), 2);
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public BooleanProperty getGrowConditionProperty() {
        return GROW_CONDITION;
    }
}
