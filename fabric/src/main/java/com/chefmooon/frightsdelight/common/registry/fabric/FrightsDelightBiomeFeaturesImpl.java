package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightBiomeFeatures;
import com.chefmooon.frightsdelight.common.world.configuration.WildBushConfiguration;
import com.chefmooon.frightsdelight.common.world.feature.WildBushFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class FrightsDelightBiomeFeaturesImpl {
    public static final Feature<? extends FeatureConfiguration> WILD_BUSH = registerFeature(FrightsDelightBiomeFeatures.WILD_BUSH, new WildBushFeature(WildBushConfiguration.CODEC));

    public static Feature<? extends FeatureConfiguration> registerFeature(ResourceLocation location, Feature<? extends FeatureConfiguration> feature) {
        return Registry.register(BuiltInRegistries.FEATURE, location, feature);
    }

    public static void register() {

    }
}
