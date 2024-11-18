package com.chefmooon.frightsdelight.common.block.drinkableFeastBlocks;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class WitherBerryDrinkableFeastBlock extends DrinkableFeastBlock {
    public WitherBerryDrinkableFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        particleData = (SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE.get(TextUtils.res("wither_berry_bubble"));
        animate(state, level, pos, FrightsDelightSounds.BLOCK_DRINKABLE_FEAST_WITHER_BERRY_BUBBLE.get(), random);
    }
}
