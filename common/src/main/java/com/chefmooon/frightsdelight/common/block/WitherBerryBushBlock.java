package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WitherBerryBushBlock extends FrightsDelightBushBlock {
    public static final int GROW_RANGE = 1;
    public static final TagKey<Block> GROW_CONDITION_BLOCK = FrightsDelightTags.WITHER_BERRY_BUSH_GROW_CONDITIION;
    public WitherBerryBushBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = (Integer)state.getValue(AGE);
        updateGrowthCondition(state, level, pos, GROW_RANGE, GROW_CONDITION_BLOCK);
        if (state.getValue(GROW_CONDITION)) {
            if (i < 3 && random.nextInt(5) == 0 && level.getRawBrightness(pos.above(), 0) >= 7) {
                BlockState blockState = (BlockState)state.setValue(AGE, i + 1);
                level.setBlock(pos, blockState, 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockState));
            }
        }
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(GROW_CONDITION)) {
            VoxelShape voxelShape = this.getShape(state, level, pos, CollisionContext.empty());
            Vec3 vec3 = voxelShape.bounds().getCenter();
            double d = (double)pos.getX() + vec3.x;
            double e = (double)pos.getZ() + vec3.z;

            for(int i = 0; i < 3; ++i) {
                if (random.nextBoolean()) {
                    level.addParticle(ParticleTypes.SMOKE, d + random.nextDouble() / 5.0, (double)pos.getY() + (0.5 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            updateGrowthCondition(state, (ServerLevel)level, pos, GROW_RANGE, GROW_CONDITION_BLOCK);
        }
        int i = (Integer)state.getValue(AGE);
        boolean bl = i == 3;
        if (!bl && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY), j + (bl ? 1 : 0)));
            level.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockState = (BlockState)state.setValue(AGE, 1);
            level.setBlock(pos, blockState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(state, level, pos, player, hand, hit);
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        updateGrowthCondition(state, level, pos, GROW_RANGE, GROW_CONDITION_BLOCK);
        if (state.getValue(GROW_CONDITION)) {
            super.performBonemeal(level, random, pos, state);
        }
    }
}
