package com.chefmooon.frightsdelight.common.block;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class SoulBerryBushBlock extends FrightsDelightBushBlock {
    public static final int GROW_RANGE = 5;
    public static final TagKey<Block> GROW_CONDITION_BLOCK = FrightsDelightTags.SOUL_BERRY_BUSH_GROW_CONDITIION;
    public SoulBerryBushBlock() {
        super(Block.Properties.copy(Blocks.SWEET_BERRY_BUSH));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return new ItemStack(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true; // TODO: is this bad? maybe use new BooleanProperty TRANSFORM_CONDITION?
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int i = (Integer)state.getValue(AGE);
        updateGrowthCondition(state, level, pos, GROW_RANGE, GROW_CONDITION_BLOCK);
        if (state.getValue(GROW_CONDITION)) {
            if (i < 3 && random.nextInt(5) == 0 && level.getRawBrightness(pos.above(), 0) >= 9) {
                BlockState blockState = (BlockState)state.setValue(AGE, i + 1);
                level.setBlock(pos, blockState, 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockState));
            }
        }
        if (i == 3 && level.getRawBrightness(pos.above(), 0) <= 7 && hasTransformCondition(level, pos, GROW_RANGE)) {
            BlockState blockState = (BlockState)BuiltInRegistries.BLOCK.get(FrightsDelightBlocks.WITHER_BERRY_BUSH).defaultBlockState()
                    .setValue(WitherBerryBushBlock.GROW_CONDITION, Boolean.TRUE)
                    .setValue(WitherBerryBushBlock.AGE, 3);
            level.playSound((Player)null, pos, SoundEvents.SOUL_SAND_PLACE, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, blockState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockState));
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
            popResource(level, pos, new ItemStack(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY), j + (bl ? 1 : 0)));
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

    public static boolean hasTransformCondition(ServerLevel level, BlockPos pos, int range) {
        for (BlockPos blockPos : BlockPos.betweenClosed(BlockPos.of(BlockPos.offset(pos.asLong(), -range, -1, -range)),
                BlockPos.of(BlockPos.offset(pos.asLong(), range, 1, range)))) {
            if (level.getBlockState(blockPos).is(WitherBerryBushBlock.GROW_CONDITION_BLOCK)) {
                return true;
            }
        }
        return false;
    }
}
