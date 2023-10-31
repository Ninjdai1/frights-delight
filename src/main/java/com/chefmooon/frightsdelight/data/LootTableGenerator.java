package com.chefmooon.frightsdelight.data;

import com.chefmooon.frightsdelight.registry.BlocksRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class LootTableGenerator extends FabricBlockLootTableProvider {
    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        addDrop(BlocksRegistry.FLESH_CRATE.get());
        addDrop(BlocksRegistry.BONE_CRATE.get());
        addDrop(BlocksRegistry.PHANTOM_CRATE.get());
        addDrop(BlocksRegistry.WEB_CRATE.get());
        addDrop(BlocksRegistry.SPIDER_EYE_CRATE.get());
        addDrop(BlocksRegistry.FERMENTED_SPIDER_EYE_CRATE.get());
        addDrop(BlocksRegistry.POISONOUS_POTATO_CRATE.get());
        addDrop(BlocksRegistry.ROTTEN_TOMATO_CRATE.get());
    }
}
