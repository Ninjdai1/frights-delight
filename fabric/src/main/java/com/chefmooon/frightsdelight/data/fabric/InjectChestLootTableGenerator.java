package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class InjectChestLootTableGenerator extends SimpleFabricLootTableProvider {
    public InjectChestLootTableGenerator(FabricDataOutput output) {
        super(output, LootContextParamSets.CHEST);
    }

    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> output) {

        output.accept(BuiltInLootTables.BASTION_BRIDGE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f, 2.0f))
                .add(LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))))));
        output.accept(BuiltInLootTables.BASTION_OTHER, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f, 2.0f))
                .add(LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f))))));
        output.accept(BuiltInLootTables.BASTION_TREASURE, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(UniformGenerator.between(1.0f, 2.0f))
                .add(LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 6.0f))))));
    }
}
