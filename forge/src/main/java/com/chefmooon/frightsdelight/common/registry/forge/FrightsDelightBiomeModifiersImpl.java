package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightBiomeModifiers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FrightsDelightBiomeModifiersImpl {
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_SOUL_BERRY_BUSHES = modConfiguredFeature(FrightsDelightBiomeModifiers.PATCH_WILD_SOUL_BERRY_BUSHES);

    public static ResourceKey<PlacedFeature> PATCH_WILD_SOUL_BERRY_BUSH = modPlacedFeature(FrightsDelightBiomeModifiers.PATCH_WILD_SOUL_BERRY_BUSHES);

    private static ResourceKey<ConfiguredFeature<?, ?>> modConfiguredFeature(ResourceLocation location) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, location);
    }
    private static ResourceKey<PlacedFeature> modPlacedFeature(ResourceLocation location) {
        return ResourceKey.create(Registries.PLACED_FEATURE, location);
    }
    public static void init() {

    }
}
