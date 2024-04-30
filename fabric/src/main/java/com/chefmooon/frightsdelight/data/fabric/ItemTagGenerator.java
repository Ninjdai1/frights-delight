package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        registerCompatibilityItemTags();
    }

    private void registerCompatibilityItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get())
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get())
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY.get())
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIME.get());

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get());

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get())
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get())
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get())
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get())
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get());

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE.get())
                .add(FrightsDelightItemsImpl.SOUP_SLIME.get());

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(FrightsDelightItemsImpl.UNDEAD_KEBAB.get())
                .add(FrightsDelightItemsImpl.MONSTER_MASH.get())
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH.get())
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE.get());
    }
}
