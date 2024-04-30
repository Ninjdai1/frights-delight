package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.tag.CommonTags;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        registerModTags();
        registerCommonBlockTags();
        registerMinecraftBlockTags();
    }
    private void registerModTags() {
        getOrCreateTagBuilder(FrightsDelightTags.SOUL_BERRY_BUSH_GROW_CONDITIION)
                .add(Blocks.SOUL_FIRE)
                .add(Blocks.SOUL_LANTERN)
                .add(Blocks.SOUL_TORCH)
                .add(Blocks.SOUL_WALL_TORCH)
                .add(Blocks.SOUL_CAMPFIRE);

        getOrCreateTagBuilder(FrightsDelightTags.WITHER_BERRY_BUSH_GROW_CONDITIION)
                .add(Blocks.WITHER_ROSE)
                .add(Blocks.WITHER_SKELETON_SKULL)
                .add(Blocks.WITHER_SKELETON_WALL_SKULL);
    }

    private void registerCommonBlockTags() {
        getOrCreateTagBuilder(CommonTags.C_MINEABLE_KNIFE)
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get())
                .add(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get());
    }

    private void registerMinecraftBlockTags() {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(FrightsDelightBlocksImpl.FLESH_CRATE.get())
                .add(FrightsDelightBlocksImpl.BONE_CRATE.get())
                .add(FrightsDelightBlocksImpl.PHANTOM_CRATE.get())
                .add(FrightsDelightBlocksImpl.WEB_CRATE.get())
                .add(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get())
                .add(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get())
                .add(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get())
                .add(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get());
    }
}
