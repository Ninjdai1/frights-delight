package com.chefmooon.frightsdelight.block;

import com.chefmooon.frightsdelight.registry.ItemsRegistry;
import com.chefmooon.frightsdelight.tag.ModTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class WitherBerryBushBlock extends SweetBerryBushBlock {
    public static final BooleanProperty GROW_CONDITION = BooleanProperty.of("grow_condition");
    public static final int GROW_RANGE = 1;
    public WitherBerryBushBlock() {
        super(FabricBlockSettings.copy(Blocks.SWEET_BERRY_BUSH));
        setDefaultState(((getStateManager().getDefaultState()).with(GROW_CONDITION, false).with(AGE, 0)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GROW_CONDITION, AGE);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        return (BlockState)((BlockState)this.getDefaultState().with(GROW_CONDITION, Boolean.FALSE).with(AGE, 0));
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ItemsRegistry.WITHER_BERRY.get());
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(BlockTags.SOUL_SPEED_BLOCKS);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!world.isClient()) { // Is this correct?
            updateGrowthCondition(state, (ServerWorld) world, pos);
        }
        return !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer)state.get(AGE);

        updateGrowthCondition(state, world, pos);
        if (Boolean.TRUE.equals(state.get(GROW_CONDITION))) {
            if (i < 3 && random.nextInt(5) == 0 && world.getBaseLightLevel(pos.up(), 0) <= 7) {
                BlockState blockState = (BlockState)state.with(AGE, i + 1);
                world.setBlockState(pos, blockState, 2);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
            }
        }
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        updateGrowthCondition(state, world, pos);
        if (Boolean.TRUE.equals(state.get(GROW_CONDITION))) {
            int i = Math.min(3, (Integer)state.get(AGE) + 1);
            world.setBlockState(pos, (BlockState)state.with(AGE, i), 2);
        }
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) { // Is this correct?
            updateGrowthCondition(state, (ServerWorld) world, pos);
        }
        int i = (Integer)state.get(AGE);
        boolean bl = i == 3;
        if (!bl && player.getStackInHand(hand).isOf(Items.BONE_MEAL)) {
            return ActionResult.PASS;
        } else if (i > 1) {
            int j = 1 + world.random.nextInt(2);
            dropStack(world, pos, new ItemStack(ItemsRegistry.WITHER_BERRY.get(), j + (bl ? 1 : 0)));
            world.playSound((PlayerEntity)null, pos, SoundEvents.BLOCK_SWEET_BERRY_BUSH_PICK_BERRIES, SoundCategory.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
            BlockState blockState = (BlockState)state.with(AGE, 1);
            world.setBlockState(pos, blockState, 2);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, blockState));
            return ActionResult.success(world.isClient);
        } else {
            return super.onUse(state, world, pos, player, hand, hit);
        }
    }
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (Boolean.TRUE.equals(state.get(GROW_CONDITION))) {
            VoxelShape voxelShape = this.getOutlineShape(state, world, pos, ShapeContext.absent());
            Vec3d vec3d = voxelShape.getBoundingBox().getCenter();
            double d = (double)pos.getX() + vec3d.x;
            double e = (double)pos.getZ() + vec3d.z;

            for(int i = 0; i < 3; ++i) {
                if (random.nextBoolean()) {
                    world.addParticle(ParticleTypes.SMOKE, d + random.nextDouble() / 5.0, (double)pos.getY() + (1.0 - random.nextDouble()), e + random.nextDouble() / 5.0, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    private boolean hasGrowthCondition(ServerWorld world, BlockPos pos) {
        boolean result = false;
        for (BlockPos blockpos : BlockPos.iterate(pos.add(-GROW_RANGE, 0, -GROW_RANGE), pos.add(GROW_RANGE, 1, GROW_RANGE))) {
            if (world.getBlockState(blockpos).isIn(ModTags.WITHER_BERRY_BUSH_GROW_CONDITIION)) {
                return true;
            }
        }
        return result;
    }

    private void updateGrowthCondition(BlockState state, ServerWorld world, BlockPos pos) {
        Boolean hasGrowthCondition = hasGrowthCondition(world, pos);
        world.setBlockState(pos, (BlockState)state.with(GROW_CONDITION, hasGrowthCondition));
    }
}
