package com.chefmooon.frightsdelight.common.event.fabric;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class FrightsDelightLootTableEvents {
    private static final ResourceKey<LootTable> BASTION_BRIDGE_ID = BuiltInLootTables.BASTION_BRIDGE;
    private static final ResourceKey<LootTable> BASTION_OTHER_ID = BuiltInLootTables.BASTION_OTHER;
    private static final ResourceKey<LootTable> BASTION_TREASURE_ID = BuiltInLootTables.BASTION_TREASURE;

    public static void registerLootTable() {

        if (Configuration.generateSoulBerryLoot()) {
            LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
                if (BASTION_BRIDGE_ID.equals(key)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .conditionally(LootItemRandomChanceCondition.randomChance(0.5F).build())
                            .add(LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (BASTION_OTHER_ID.equals(key)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .conditionally(LootItemRandomChanceCondition.randomChance(0.5F).build())
                            .add(LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)).build());
                    tableBuilder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE_ID.equals(key)) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .conditionally(LootItemRandomChanceCondition.randomChance(1.0F).build())
                            .add(LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(3.0f, 5.0f)).build());
                    tableBuilder.pool(poolBuilder.build());
                }
            });
        }
    }
}
