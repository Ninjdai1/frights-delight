package com.chefmooon.frightsdelight.data.fabric.recipe;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.data.fabric.builder.CookingPotRecipeJsonBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;

public class CookingRecipes {

    public static void register(RecipeOutput recipeOutput) {

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.APPLE_SLIME, 1, 100, 1.0F,
                nonNullList(Ingredient.of(Items.SLIME_BALL),
                        Ingredient.of(Items.APPLE)))
                .unlockedByAny(Items.SLIME_BALL, Items.APPLE)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.APPLE_SLIME));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.UNDEAD_KEBAB, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(Items.ROTTEN_FLESH),
                                Ingredient.of(Items.GHAST_TEAR),
                                Ingredient.of(Items.SPIDER_EYE)))
                .unlockedByAny(Items.ROTTEN_FLESH, Items.GHAST_TEAR, Items.SPIDER_EYE, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.UNDEAD_KEBAB));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(Items.ROTTEN_FLESH),
                                Ingredient.of(Items.ROTTEN_FLESH)))
                .unlockedByAny(Items.ROTTEN_FLESH, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(Items.SPIDER_EYE),
                                Ingredient.of(Items.SPIDER_EYE),
                                Ingredient.of(Items.SPIDER_EYE)))
                .unlockedByAny(Items.SPIDER_EYE, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.BONE_KEBAB_SLIME, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(Items.SLIME_BALL),
                                Ingredient.of(Items.SLIME_BALL),
                                Ingredient.of(Items.SLIME_BALL)))
                .unlockedByAny(Items.SLIME_BALL, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SLIME));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(FrightsDelightItemsImpl.APPLE_SLIME),
                                Ingredient.of(FrightsDelightItemsImpl.APPLE_SLIME)))
                .unlockedByAny(FrightsDelightItemsImpl.APPLE_SLIME, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.WEB_ON_STICK, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(Items.COBWEB),
                                Ingredient.of(Items.COBWEB)))
                .unlockedByAny(Items.COBWEB, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.WEB_ON_STICK));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(Items.GHAST_TEAR),
                                Ingredient.of(Items.GHAST_TEAR),
                                Ingredient.of(Items.GHAST_TEAR)))
                .unlockedByAny(Items.GHAST_TEAR, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(FrightsDelightItemsImpl.SOUL_BERRY),
                                Ingredient.of(FrightsDelightItemsImpl.SOUL_BERRY)))
                .unlockedByAny(FrightsDelightItemsImpl.SOUL_BERRY, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(FrightsDelightItemsImpl.WITHER_BERRY),
                                Ingredient.of(FrightsDelightItemsImpl.WITHER_BERRY)))
                .unlockedByAny(FrightsDelightItemsImpl.WITHER_BERRY, FrightsDelightItemsImpl.BONE_SHARD)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.MONSTER_MASH, 1, 100, 1.0F,
                        nonNullList(Ingredient.of(Items.GHAST_TEAR),
                                Ingredient.of(Items.SPIDER_EYE),
                                Ingredient.of(Items.SPIDER_EYE),
                                Ingredient.of(Items.ROTTEN_FLESH)))
                .unlockedByAny(Items.SPIDER_EYE, Items.SPIDER_EYE, Items.ROTTEN_FLESH)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.MONSTER_MASH));

        CookingPotRecipeJsonBuilder.create(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS, 1, 75, 2.0F,
                nonNullList(Ingredient.of(Items.SLIME_BALL),
                        Ingredient.of(ModItems.RAW_PASTA.get()),
                        Ingredient.of(Items.SLIME_BALL)))
                .unlockedByAny(FrightsDelightItemsImpl.SOUL_BERRY)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS));

        punchRecipe(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, Items.ROTTEN_FLESH, recipeOutput);
        punchRecipe(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, Items.SPIDER_EYE, recipeOutput);
        punchRecipe(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, FrightsDelightItemsImpl.APPLE_SLIME, recipeOutput);
        punchRecipe(FrightsDelightItemsImpl.PUNCH_COBWEB, Items.COBWEB, recipeOutput);
        punchRecipe(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, Items.GHAST_TEAR, recipeOutput);
        punchRecipe(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, FrightsDelightItemsImpl.SOUL_BERRY, recipeOutput);
        punchRecipe(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, FrightsDelightItemsImpl.WITHER_BERRY, recipeOutput);

        soupRecipe(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH, Items.ROTTEN_FLESH, recipeOutput);
        soupRecipe(FrightsDelightItemsImpl.SOUP_SPIDER_EYE, Items.SPIDER_EYE, recipeOutput);
        soupRecipe(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE, Items.SLIME_BALL, recipeOutput);
        soupRecipe(FrightsDelightItemsImpl.SOUP_COBWEB, Items.COBWEB, recipeOutput);
        soupRecipe(FrightsDelightItemsImpl.SOUP_GHAST_TEAR, Items.GHAST_TEAR, recipeOutput);
        soupRecipe(FrightsDelightItemsImpl.SOUP_SOUL_BERRY, FrightsDelightItemsImpl.SOUL_BERRY, recipeOutput);
        soupRecipe(FrightsDelightItemsImpl.SOUP_WITHER_BERRY, FrightsDelightItemsImpl.WITHER_BERRY, recipeOutput);

    }

    private static void punchRecipe(Item output, Item mainIngredient, RecipeOutput recipeOutput) {
        CookingPotRecipeJsonBuilder.create(output, 4, 200, 1.0F,
                        nonNullList(Ingredient.of(mainIngredient),
                                Ingredient.of(mainIngredient),
                                Ingredient.of(Items.SUGAR),
                                Ingredient.of(Items.WATER_BUCKET)))
                .unlockedByAny(mainIngredient, Items.SUGAR, Items.WATER_BUCKET)
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(output));
    }

    private static void soupRecipe(Item output, Item mainIngredient, RecipeOutput recipeOutput) {
        CookingPotRecipeJsonBuilder.create(output, 1, 200, 2.0F,
                nonNullList(Ingredient.of(mainIngredient),
                        Ingredient.of(CommonTags.C_FOODS_VEGETABLE),
                        Ingredient.of(mainIngredient)))
                .unlockedByAny(mainIngredient)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(recipeOutput, RecipeProvider.getSimpleRecipeName(output));
    }


    public static NonNullList<Ingredient> nonNullList(Ingredient ... ingredients) {
        NonNullList<Ingredient> newList = NonNullList.create();
        newList.addAll(List.of(ingredients));
        return newList;
    }
}
