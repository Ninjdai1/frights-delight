package com.chefmooon.frightsdelight.data;

import com.chefmooon.frightsdelight.registry.BlocksRegistry;
import com.chefmooon.frightsdelight.tag.CommonTags;
import com.chefmooon.frightsdelight.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        registerModTags();
        registerCommonBlockTags();
        registerMinecraftBlockTags();
    }

    private void registerModTags() {
        getOrCreateTagBuilder(ModTags.SOUL_BERRY_BUSH_GROW_CONDITIION)
                .add(Blocks.SOUL_FIRE)
                .add(Blocks.SOUL_LANTERN)
                .add(Blocks.SOUL_TORCH)
                .add(Blocks.SOUL_WALL_TORCH)
                .add(Blocks.SOUL_CAMPFIRE);

        getOrCreateTagBuilder(ModTags.WITHER_BERRY_BUSH_GROW_CONDITIION)
                .add(Blocks.WITHER_ROSE)
                .add(Blocks.WITHER_SKELETON_SKULL)
                .add(Blocks.WITHER_SKELETON_WALL_SKULL);
    }

    private void registerCommonBlockTags() {
        getOrCreateTagBuilder(CommonTags.C_MINEABLE_KNIFE)
                .add(BlocksRegistry.PUNCHBOWL_SLIMEAPPLE.get())
                .add(BlocksRegistry.PUNCHBOWL_SPIDEREYE.get())
                .add(BlocksRegistry.PUNCHBOWL_GHASTTEAR.get())
                .add(BlocksRegistry.PUNCHBOWL_SOUL_BERRY.get())
                .add(BlocksRegistry.PUNCHBOWL_WITHER_BERRY.get());
    }

    private void registerMinecraftBlockTags() {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BlocksRegistry.FLESH_CRATE.get())
                .add(BlocksRegistry.BONE_CRATE.get())
                .add(BlocksRegistry.PHANTOM_CRATE.get())
                .add(BlocksRegistry.WEB_CRATE.get())
                .add(BlocksRegistry.SPIDER_EYE_CRATE.get())
                .add(BlocksRegistry.FERMENTED_SPIDER_EYE_CRATE.get())
                .add(BlocksRegistry.POISONOUS_POTATO_CRATE.get())
                .add(BlocksRegistry.ROTTEN_TOMATO_CRATE.get());
    }
}
