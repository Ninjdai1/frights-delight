package com.chefmooon.frightsdelight.data;

import com.chefmooon.frightsdelight.registry.ItemsRegistry;
import com.chefmooon.frightsdelight.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        registerCompatibilityItemTags();
    }

    private void registerCompatibilityItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(ItemsRegistry.PUNCH_SLIMEAPPLE.get())
                .add(ItemsRegistry.PUNCH_SPIDEREYE.get())
                .add(ItemsRegistry.PUNCH_GHASTTEAR.get())
                .add(ItemsRegistry.PUNCH_SOUL_BERRY.get())
                .add(ItemsRegistry.PUNCH_WITHER_BERRY.get())
                .add(ItemsRegistry.PUNCHBOWL_SPIDEREYE.get())
                .add(ItemsRegistry.PUNCHBOWL_SLIMEAPPLE.get())
                .add(ItemsRegistry.PUNCHBOWL_GHASTTEAR.get())
                .add(ItemsRegistry.PUNCHBOWL_SOUL_BERRY.get())
                .add(ItemsRegistry.PUNCHBOWL_WITHER_BERRY.get())
                .add(ItemsRegistry.SOUP_ROTTEN_FLESH.get())
                .add(ItemsRegistry.SOUP_SPIDER_EYE.get())
                .add(ItemsRegistry.SOUP_SLIME.get());

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(ItemsRegistry.COOKIE_SOUL_BERRY.get())
                .add(ItemsRegistry.COOKIE_FLESH.get())
                .add(ItemsRegistry.COOKIE_SPIDEREYE.get());
    }
}
