package com.chefmooon.frightsdelight.common.block;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class SlimeAppleDrinkableFeastBlock extends DrinkableFeastBlock {
    // TODO: maybe remove, testing for forge particles
    public SlimeAppleDrinkableFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties);
        //super(servingItem, (SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE.get(new ResourceLocation(FrightsDelight.MOD_ID, "slime_bubble")), properties);
        //this.particleData = (SimpleParticleType) BuiltInRegistries.PARTICLE_TYPE.get(new ResourceLocation(FrightsDelight.MOD_ID, "slime_bubble"));
    }
}
