package com.chefmooon.frightsdelight.common.block.drinkableFeastBlocks;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class SlimeAppleDrinkableFeastBlock extends DrinkableFeastBlock {
    public SlimeAppleDrinkableFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        particleData = (SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE.get(new ResourceLocation(FrightsDelight.MOD_ID, "slime_bubble"));
        animate(state, level, pos, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_SLIMEAPPLE_BUBBLE.get(), random);
    }
}
