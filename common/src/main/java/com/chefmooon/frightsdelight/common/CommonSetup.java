package com.chefmooon.frightsdelight.common;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.ComposterBlock;

public class CommonSetup {

    public static void init() {
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.SOUL_BERRY), 0.3F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.WITHER_BERRY), 0.3F);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.APPLE_SLIME), 0.65F);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SOUL_BERRY), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_WITHER_BERRY), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_ROTTEN_FLESH), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SPIDER_EYE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SLIMEAPPLE), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_SLIME), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_COBWEB), 0.85F);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistries.ITEM.get(FrightsDelightItems.COOKIE_GHAST_TEAR), 0.85F);
    }
}
