package com.chefmooon.frightsdelight.data;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    private static final String ROOT = "minecraft/crafting/";

    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        /** CRATES **/
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.ROTTEN_FLESH, RecipeCategory.MISC, ItemsRegistry.FLESH_CRATE.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.BONE, RecipeCategory.MISC, ItemsRegistry.BONE_CRATE.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.PHANTOM_MEMBRANE, RecipeCategory.MISC, ItemsRegistry.PHANTOM_CRATE.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.COBWEB, RecipeCategory.MISC, ItemsRegistry.WEB_CRATE.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.SPIDER_EYE, RecipeCategory.MISC, ItemsRegistry.SPIDER_EYE_CRATE.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.FERMENTED_SPIDER_EYE, RecipeCategory.MISC, ItemsRegistry.FERMENTED_SPIDER_EYE_CRATE.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.POISONOUS_POTATO, RecipeCategory.MISC, ItemsRegistry.POISONOUS_POTATO_CRATE.get());
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.ROTTEN_TOMATO.get(), RecipeCategory.MISC, ItemsRegistry.ROTTEN_TOMATO_CRATE.get());

        /** FOODS **/
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.COOKIE_SOUL_BERRY.get(), 8)
                .input(ItemsRegistry.SOUL_BERRY.get())
                .input(Items.WHEAT, 2)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.SOUL_BERRY.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.SOUL_BERRY.get()))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.COOKIE_SOUL_BERRY.get())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.COOKIE_FLESH.get(), 8)
                .input(Items.ROTTEN_FLESH)
                .input(Items.WHEAT, 2)
                .criterion(RecipeProvider.hasItem(Items.ROTTEN_FLESH), RecipeProvider.conditionsFromItem(Items.ROTTEN_FLESH))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.COOKIE_FLESH.get())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.COOKIE_SPIDEREYE.get(), 8)
                .input(Items.SPIDER_EYE)
                .input(Items.WHEAT, 2)
                .criterion(RecipeProvider.hasItem(Items.SPIDER_EYE), RecipeProvider.conditionsFromItem(Items.SPIDER_EYE))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.COOKIE_SPIDEREYE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.PUNCHBOWL_SPIDEREYE.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .input('A', ItemsRegistry.PUNCH_SPIDEREYE.get())
                .criterion(RecipeProvider.hasItem(ItemsRegistry.PUNCH_SPIDEREYE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.PUNCH_SPIDEREYE.get()))
                .showNotification(false)
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.PUNCHBOWL_SPIDEREYE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.PUNCHBOWL_SLIMEAPPLE.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .input('A', ItemsRegistry.PUNCH_SLIMEAPPLE.get())
                .criterion(RecipeProvider.hasItem(ItemsRegistry.PUNCH_SPIDEREYE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.PUNCH_SPIDEREYE.get()))
                .showNotification(false)
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.PUNCHBOWL_SLIMEAPPLE.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.PUNCHBOWL_GHASTTEAR.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .input('A', ItemsRegistry.PUNCH_GHASTTEAR.get())
                .criterion(RecipeProvider.hasItem(ItemsRegistry.PUNCH_SPIDEREYE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.PUNCH_SPIDEREYE.get()))
                .showNotification(false)
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.PUNCHBOWL_GHASTTEAR.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.PUNCHBOWL_SOUL_BERRY.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .input('A', ItemsRegistry.PUNCH_SOUL_BERRY.get())
                .criterion(RecipeProvider.hasItem(ItemsRegistry.PUNCH_SPIDEREYE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.PUNCH_SPIDEREYE.get()))
                .showNotification(false)
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.PUNCHBOWL_SOUL_BERRY.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.PUNCHBOWL_WITHER_BERRY.get())
                .pattern(" A ")
                .pattern("A A")
                .pattern(" A ")
                .input('A', ItemsRegistry.PUNCH_WITHER_BERRY.get())
                .criterion(RecipeProvider.hasItem(ItemsRegistry.PUNCH_SPIDEREYE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.PUNCH_SPIDEREYE.get()))
                .showNotification(false)
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.getRecipeName(ItemsRegistry.PUNCHBOWL_WITHER_BERRY.get())));

    }

    private void simpleRecipeBuilder(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemsRegistry input, Integer inputCount, ItemsRegistry output, Integer outputCount) {
        ShapelessRecipeJsonBuilder.create(category, output.get(), outputCount)
                .input(input.get(), inputCount)
                .criterion(RecipeProvider.hasItem(output.get()), RecipeProvider.conditionsFromItem(output.get()))
                .criterion(RecipeProvider.hasItem(input.get()), RecipeProvider.conditionsFromItem(input.get()))
                .group(FrightsDelight.ITEM_GROUP.getValue().getPath())
                .offerTo(exporter, new Identifier(ROOT + RecipeProvider.convertBetween(output.get(), input.get())));
    }
}
