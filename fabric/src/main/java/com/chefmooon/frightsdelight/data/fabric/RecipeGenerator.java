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

        // TODO: figure out how to have fabric/forge sourceSet override common sourceSet
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.FLESH_CRATE.get());
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.BONE, RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.BONE_CRATE.get());
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.PHANTOM_CRATE.get());
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.COBWEB, RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.WEB_CRATE.get());
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.SPIDER_EYE, RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.SPIDER_EYE_CRATE.get());
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.FERMENTED_SPIDER_EYE, RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE.get());
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, Items.POISONOUS_POTATO, RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE.get());
        //nineBlockStorageRecipes(exporter, RecipeCategory.MISC, ModItems.ROTTEN_TOMATO.get(), RecipeCategory.DECORATIONS, FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE.get());

        crateToIngredient(FrightsDelightItemsImpl.FLESH_CRATE.get(), Items.ROTTEN_FLESH, exporter);
        crateToIngredient(FrightsDelightItemsImpl.BONE_CRATE.get(), Items.BONE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.PHANTOM_CRATE.get(), Items.PHANTOM_MEMBRANE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.WEB_CRATE.get(), Items.COBWEB, exporter);
        crateToIngredient(FrightsDelightItemsImpl.SPIDER_EYE_CRATE.get(), Items.SPIDER_EYE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE.get(), Items.FERMENTED_SPIDER_EYE, exporter);
        crateToIngredient(FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE.get(), Items.POISONOUS_POTATO, exporter);
        crateToIngredient(FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE.get(), ModItems.ROTTEN_TOMATO.get(), exporter);

        cookie(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get(), FrightsDelightItemsImpl.SOUL_BERRY.get(), exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get(), Items.ROTTEN_FLESH, exporter);
        cookie(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get(), Items.SPIDER_EYE, exporter);

        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE.get(), FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE.get(), FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR.get(), FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY.get(), FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), exporter);
        punchbowlFromPunch(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY.get(), FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), exporter);
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
