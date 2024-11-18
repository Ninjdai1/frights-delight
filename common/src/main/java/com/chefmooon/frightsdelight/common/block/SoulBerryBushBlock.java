package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class SoulBerryBushBlock extends FrightsDelightBushBlock {
    public static final int GROW_RANGE = 5;
    public static final TagKey<Block> GROW_CONDITION_BLOCK = FrightsDelightTags.SOUL_BERRY_BUSH_GROW_CONDITIION;
    public static final BooleanProperty TRANSFORM_CONDITION = BooleanProperty.create("transform_condition");
    public SoulBerryBushBlock() {
        super(Block.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();

        BlockState state = this.defaultBlockState().setValue(AGE, 0)
                .setValue(TRANSFORM_CONDITION, Boolean.FALSE);

        return state.setValue(GROW_CONDITION, hasGrowthCondition(level, pos, GROW_RANGE, GROW_CONDITION_BLOCK));
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = (Integer)state.getValue(AGE);
        updateConditions(state, level, pos);
        if (state.getValue(GROW_CONDITION)) {
            if (i < 3 && random.nextInt(5) == 0 && hasGrowBrightness(level.getRawBrightness(pos.above(), 0))) {
                BlockState blockState = (BlockState)state.setValue(AGE, i + 1);
                level.setBlock(pos, blockState, 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockState));
            }
        }
        if (i == 3 && hasTransformBrightness(level.getRawBrightness(pos.above(), 0)) && hasTransformCondition(level, pos)) {
            BlockState blockState = (BlockState)BuiltInRegistries.BLOCK.get(FrightsDelightBlocks.WITHER_BERRY_BUSH).defaultBlockState()
                    .setValue(WitherBerryBushBlock.GROW_CONDITION, Boolean.TRUE)
                    .setValue(WitherBerryBushBlock.AGE, 3);
            level.playSound((Player)null, pos, SoundEvents.SOUL_SAND_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, blockState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockState));
        }
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!level.isClientSide()) {
            updateConditions(state, level, pos);
        }
        InteractionHand hand = player.getUsedItemHand();
        int i = (Integer)state.getValue(AGE);
        boolean bl = i == 3;
        if (!bl && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY), j + (bl ? 1 : 0)));
            level.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockState = (BlockState)state.setValue(AGE, 1);
            level.setBlock(pos, blockState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useWithoutItem(state, level, pos, player, hit);
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        updateConditions(state, level, pos);
        super.performBonemeal(level, random, pos, state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (!level.isClientSide()) {
            updateConditions(state, level, pos);
        }
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(TRANSFORM_CONDITION);
    }

    public static boolean hasTransformCondition(LevelAccessor level, BlockPos pos) {
        int TRANSFORM_GROW_RANGE = WitherBerryBushBlock.GROW_RANGE;
        for (BlockPos blockPos : BlockPos.betweenClosed(BlockPos.of(BlockPos.offset(pos.asLong(), -TRANSFORM_GROW_RANGE, -1, -TRANSFORM_GROW_RANGE)),
                BlockPos.of(BlockPos.offset(pos.asLong(), TRANSFORM_GROW_RANGE, 1, TRANSFORM_GROW_RANGE)))) {
            if (level.getBlockState(blockPos).is(WitherBerryBushBlock.GROW_CONDITION_BLOCK)) {
                return true;
            }
        }
        return false;
    }

    public void updateTransformCondition(BlockState state, LevelAccessor level, BlockPos pos, boolean oldCondition) {
        boolean newCondition = hasTransformCondition(level, pos);
        if (newCondition != oldCondition) {
            level.setBlock(pos, (BlockState)state.setValue(TRANSFORM_CONDITION, newCondition), 2);
        }
    }

    public void updateConditions(BlockState state, LevelAccessor level, BlockPos pos) {
        // todo - review me
        if (level instanceof ServerLevel serverLevel) {
            updateGrowthCondition(state, serverLevel, pos, GROW_RANGE, GROW_CONDITION_BLOCK, state.getValue(GROW_CONDITION));
            updateTransformCondition(state, level, pos, state.getValue(TRANSFORM_CONDITION));
        }
    }

    public static boolean hasGrowBrightness(int lightLevel) {
        return lightLevel >= 9;
    }

    public static boolean hasTransformBrightness(int lightLevel) {
        return lightLevel <= 7;
    }

    public BooleanProperty getTransformConditionProperty() {
        return TRANSFORM_CONDITION;
    }
}
