package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {

        crateToIngredient(FrightsDelightItemsImpl.FLESH_CRATE, Items.ROTTEN_FLESH, exporter);
        crateToIngredient(FrightsDelightItemsImpl.BONE_CRATE, Items.BONE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.PHANTOM_CRATE, Items.PHANTOM_MEMBRANE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.WEB_CRATE, Items.COBWEB, exporter);
        crateToIngredient(FrightsDelightItemsImpl.SPIDER_EYE_CRATE, Items.SPIDER_EYE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE, Items.FERMENTED_SPIDER_EYE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE, Items.POISONOUS_POTATO, exporter);
        crateToIngredient(FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE, ModItems.ROTTEN_TOMATO.get(), exporter);

        cookie(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY, FrightsDelightItemsImpl.SOUL_BERRY, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH, Items.ROTTEN_FLESH, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE, Items.SPIDER_EYE, exporter);

        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE, FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE, FrightsDelightItemsImpl.PUNCH_SPIDEREYE, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR, FrightsDelightItemsImpl.PUNCH_GHASTTEAR, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY, FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY, FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, exporter);
    }

    private static void crateToIngredient(Item crate, Item ingredient, Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ingredient, 9)
                .requires(crate)
                .unlockedBy(RecipeProvider.getHasName(crate), RecipeProvider.has(crate))
                .save(exporter, RecipeProvider.getSimpleRecipeName(ingredient) + "_from_" + RecipeProvider.getSimpleRecipeName(crate));
    }

    private static void cookie(Item cookie, Item ingredient, Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, cookie, 8)
                .requires(ingredient)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeProvider.getHasName(ingredient), RecipeProvider.has(ingredient))
                .unlockedBy(RecipeProvider.getHasName(Items.WHEAT), RecipeProvider.has(Items.WHEAT))
                .save(exporter, RecipeProvider.getSimpleRecipeName(cookie));
    }

    private static void punchbowlFromPunch(Item punchbowl, Item punch, Consumer<FinishedRecipe> exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, punchbowl)
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .define('A', punch)
                .unlockedBy(RecipeProvider.getHasName(punch), RecipeProvider.has(punch))
                .showNotification(false)
                .save(exporter, RecipeProvider.getSimpleRecipeName(punchbowl));
    }
}
