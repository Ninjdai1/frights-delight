package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBiomeFeatures;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;
import vectorwing.farmersdelight.common.world.feature.WildCropFeature;

public class FrightsDelightBiomeFeaturesImpl {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, FrightsDelight.MOD_ID);
    public static final RegistryObject<Feature<WildCropConfiguration>> WILD_BUSH = FEATURES.register(FrightsDelightBiomeFeatures.WILD_BUSH.getPath(), () -> new WildCropFeature(WildCropConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
