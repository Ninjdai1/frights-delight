package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.world.item.Item;
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

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        this.dropSelf(FrightsDelightBlocksImpl.FLESH_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.BONE_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.PHANTOM_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.WEB_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get());
        this.dropSelf(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get());

        this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get());
        this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get());
        this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get());
        this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get());
        this.createPunchbowlDrops(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get());

        this.createBushDrops(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get());
        this.createBushDrops(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get());
        //LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY.get()).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE));
        //add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(),
        //        LootTable.lootTable()
        //                .withPool(LootPool.lootPool().add(builder))
        //                .withPool(LootPool.lootPool().setRolls(UniformGenerator.between(2.0F, 3.0F))
        //                        .add(builder)
        //                        //.add(LootItem.lootTableItem(FrightsDelightItemsImpl.SOUL_BERRY.get()))
        //                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get())
        //                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SoulBerryBushBlock.AGE, 3))))
        //);

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
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(block.asItem())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FrightsDelightBushBlock.AGE, 2))))
        ).setRandomSequence(ModelLocationUtils.getModelLocation(block)));
    }
}
