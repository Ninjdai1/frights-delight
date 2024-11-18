package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBiomeFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;
import vectorwing.farmersdelight.common.world.feature.WildCropFeature;

import java.util.function.Supplier;

public class FrightsDelightBiomeFeaturesImpl {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, FrightsDelight.MOD_ID);
    public static final Supplier<Feature<WildCropConfiguration>> WILD_BUSH = FEATURES.register(FrightsDelightBiomeFeatures.WILD_BUSH.getPath(), () -> new WildCropFeature(WildCropConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
