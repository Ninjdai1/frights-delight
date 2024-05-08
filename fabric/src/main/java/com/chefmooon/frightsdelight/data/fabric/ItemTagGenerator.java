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
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME);

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE);

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY);

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME);

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(FrightsDelightItemsImpl.UNDEAD_KEBAB)
                .add(FrightsDelightItemsImpl.MONSTER_MASH)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE);
    }
}
