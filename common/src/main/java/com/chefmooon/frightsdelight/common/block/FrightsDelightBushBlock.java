package com.chefmooon.frightsdelight.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class FrightsDelightBushBlock extends SweetBerryBushBlock {
    public static final BooleanProperty GROW_CONDITION = BooleanProperty.create("grow_condition");
    public FrightsDelightBushBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(GROW_CONDITION, Boolean.FALSE).setValue(AGE, 0);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.SOUL_SPEED_BLOCKS);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(GROW_CONDITION);
    }

    public static boolean hasGrowthCondition(ServerLevel level, BlockPos pos, int range, TagKey<Block> growCondition) {
        for (BlockPos blockPos : BlockPos.betweenClosed(BlockPos.of(BlockPos.offset(pos.asLong(), -range, -1, -range)),
                BlockPos.of(BlockPos.offset(pos.asLong(), range, 1, range)))) {
            if (level.getBlockState(blockPos).is(growCondition)) {
                return true;
            }
        }
        return false;
    }

    public static void updateGrowthCondition(BlockState state, ServerLevel level, BlockPos pos, int range, TagKey<Block> growCondition) {
        level.setBlock(pos, (BlockState)state.setValue(GROW_CONDITION, hasGrowthCondition(level, pos, range, growCondition)), 2);
    }
}
