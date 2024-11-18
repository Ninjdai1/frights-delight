package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {

        this.dropSelf(FrightsDelightBlocksImpl.FLESH_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.BONE_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.PHANTOM_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.WEB_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE);
        this.dropSelf(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE);

        // can be used to regen, must change c:tools/knives -> forge:tools/kives
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE, FrightsDelightItemsImpl.PUNCH_SPIDEREYE);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR, FrightsDelightItemsImpl.PUNCH_GHASTTEAR);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY);
        //this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY);

        this.createBushDrops(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH);
        this.createBushDrops(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH);

    }

    private void createPunchbowlDrops(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 4))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 3))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 2))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 1))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIVES)))))
        ));
    }

    private void createBushDrops(Block block) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 2))))
        ).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
    }
}
