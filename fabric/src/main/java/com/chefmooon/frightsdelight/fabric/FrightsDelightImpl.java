package com.chefmooon.frightsdelight.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.event.fabric.FrightsDelightLootTableEvents;
import com.chefmooon.frightsdelight.common.event.fabric.VillagerEventsImpl;
import com.chefmooon.frightsdelight.common.fabric.CommonSetupImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrightsDelightImpl implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger(FrightsDelight.MOD_ID);
    @Override
    public void onInitialize() {
        FrightsDelight.init();

        FrightsDelightSoundsImpl.register();
        FrightsDelightBlocksImpl.register();
        FrightsDelightEffectsImpl.register();
        FrightsDelightParticleTypesImpl.register();
        FrightsDelightItemsImpl.register();
        FrightsDelightCreativeTabs.register();

        FrightsDelightLootTableEvents.registerLootTable();

        VillagerEventsImpl.init();

        CommonSetupImpl.init();
    }

    public static void loggerInfo(String s) {
        LOGGER.info(s);
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
