package com.chefmooon.frightsdelight.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.event.fabric.VillagerEventsImpl;
import com.chefmooon.frightsdelight.common.fabric.CommonSetupImpl;
import com.chefmooon.frightsdelight.common.fabric.ConfigurationImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.*;
import io.github.fabricators_of_create.porting_lib.config.ConfigRegistry;
import io.github.fabricators_of_create.porting_lib.config.ConfigType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class FrightsDelightImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        FrightsDelight.init();
        //ConfigRegistry.registerConfig(FrightsDelight.MOD_ID, ConfigType.COMMON, ConfigurationImpl.COMMON_CONFIG);
        //ConfigRegistry.registerConfig(FrightsDelight.MOD_ID, ConfigType.CLIENT, ConfigurationImpl.CLIENT_CONFIG);

        FrightsDelightSoundsImpl.SOUNDS.register();
        FrightsDelightBlocksImpl.BLOCKS.register();
        FrightsDelightEffectsImpl.MOB_EFFECTS.register();
        FrightsDelightParticleTypesImpl.PARTICLE_TYPES.register();
        FrightsDelightItemsImpl.ITEMS.register();
        FrightsDelightCreativeTabs.CREATIVE_MODE_TAB.register();

        FrightsDelightLootModifiersImpl.LOOT_MODIFIERS.register();

        VillagerEventsImpl.init();

        CommonSetupImpl.init();
    }

    public static String findVersion() {
        return FabricLoader.getInstance()
                .getModContainer(FrightsDelight.MOD_ID)
                .orElseThrow()
                .getMetadata()
                .getVersion()
                .getFriendlyString();
    }

}
