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
        registerMinecraftItemTags();
        registerCompatibilityItemTags();
    }

    private void registerMinecraftItemTags() {
        // Save for Fox harvesting implementation
        //getOrCreateTagBuilder(ItemTags.FOX_FOOD)
        //        .add(FrightsDelightItemsImpl.SOUL_BERRY);
    }

    private void registerCompatibilityItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME)
                .add(FrightsDelightItemsImpl.SOUP_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY);

        // Create: Craft's and Additions
        getOrCreateTagBuilder(CompatibilityTags.CREATE_ADDITION_PLANT_FOODS)
                .add(FrightsDelightItemsImpl.SOUL_BERRY)
                .add(FrightsDelightItemsImpl.WITHER_BERRY);

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.COOKIE_SLIME)
                .add(FrightsDelightItemsImpl.COOKIE_COBWEB)
                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY);

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY)
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB);

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME)
                .add(FrightsDelightItemsImpl.SOUP_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY)
                .add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY);

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(FrightsDelightItemsImpl.UNDEAD_KEBAB)
                .add(FrightsDelightItemsImpl.MONSTER_MASH)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_SLIME)
                .add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.COOKIE_SLIME)
                .add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE)
                .add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE)
                .add(FrightsDelightItemsImpl.SOUP_SLIME)
                .add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH)
                .add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE)
                .add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE)
        ;

        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.WEB_ON_STICK)
                .add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.COOKIE_COBWEB)
                .add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR)
                .add(FrightsDelightItemsImpl.SOUP_COBWEB)
                .add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR)
                .add(FrightsDelightItemsImpl.PUNCH_COBWEB)
        ;
    }
}
