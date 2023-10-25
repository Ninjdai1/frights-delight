package com.chefmooon.frightsdelight.data;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.registry.BlocksRegistry;
import com.chefmooon.frightsdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        registerCrateBlock(BlocksRegistry.FLESH_CRATE, BlocksRegistry.FLESH_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.BONE_CRATE, BlocksRegistry.BONE_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.PHANTOM_CRATE, BlocksRegistry.PHANTOM_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.WEB_CRATE, BlocksRegistry.WEB_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.SPIDER_EYE_CRATE, BlocksRegistry.SPIDER_EYE_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.FERMENTED_SPIDER_EYE_CRATE, BlocksRegistry.FERMENTED_SPIDER_EYE_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.POISONOUS_POTATO_CRATE, BlocksRegistry.POISONOUS_POTATO_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.ROTTEN_TOMATO_CRATE, BlocksRegistry.ROTTEN_TOMATO_CRATE.getPathName(), blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {



        itemModelGenerator.register(ItemsRegistry.SOUL_BERRY.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WITHER_BERRY.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.APPLE_SLIME.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.UNDEAD_KEBAB.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WEB_ON_STICK.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.MONSTER_MASH.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PASTA_WITH_SLIMEBALLS.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.SOUP_ROTTEN_FLESH.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.SOUP_SPIDER_EYE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.SOUP_SLIME.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.COOKIE_SOUL_BERRY.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.COOKIE_FLESH.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.COOKIE_SPIDEREYE.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.PUNCH_SLIMEAPPLE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCH_SPIDEREYE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCH_GHASTTEAR.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCH_SOUL_BERRY.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCH_WITHER_BERRY.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.PUNCHBOWL_SLIMEAPPLE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCHBOWL_SPIDEREYE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCHBOWL_GHASTTEAR.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCHBOWL_SOUL_BERRY.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PUNCHBOWL_WITHER_BERRY.get(), Models.GENERATED);
    }

    private static void registerCrateBlock(BlocksRegistry block, String name, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(block.get(),
                (new TextureMap())
                        .put(TextureKey.SIDE, new Identifier(FrightsDelight.MOD_ID, "block/" + name + "_side"))
                        .put(TextureKey.TOP, new Identifier(FrightsDelight.MOD_ID, "block/" + name + "_top"))
                        .put(TextureKey.BOTTOM, new Identifier(FrightsDelight.MOD_ID, "block/crate_bottom")),
                Models.CUBE_BOTTOM_TOP);
    }
}
