package com.chefmooon.frightsdelight.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.client.forge.FrightsDelightClientImpl;
import com.chefmooon.frightsdelight.common.forge.CommonSetupImpl;
import com.chefmooon.frightsdelight.common.forge.ConfigurationImpl;
import com.chefmooon.frightsdelight.common.registry.forge.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.MavenVersionStringHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.forgespi.language.IModInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Mod(FrightsDelight.MOD_ID)
public class FrightsDelightImpl {
    public static final Logger LOGGER = LogManager.getLogger();

    public FrightsDelightImpl() {
        FrightsDelight.init();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(CommonSetupImpl::init);
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(FrightsDelightClientImpl::init);
        }

        //ConfigurationImpl.init();
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurationImpl.COMMON_CONFIG);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigurationImpl.CLIENT_CONFIG);

        FrightsDelightSoundsImpl.SOUND_EVENTS.register(modEventBus);
        FrightsDelightBlocksImpl.BLOCKS.register(modEventBus);
        FrightsDelightEffectsImpl.MOB_EFFECTS.register(modEventBus);
        FrightsDelightParticleTypesImpl.PARTICLE_TYPES.register(modEventBus);
        FrightsDelightItemsImpl.ITEMS.register(modEventBus);
        FrightsDelightCreativeTabs.CREATIVE_MODE_TAB.register(modEventBus);

        FrightsDelightLootModifiersImpl.LOOT_MODIFIERS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static void loggerInfo(String s) {
        LOGGER.warn(s);
    }

    public static String findVersion() {
        String versionString = "UNKNOWN";

        List<IModInfo> infoList = ModList.get().getModFileById(FrightsDelight.MOD_ID).getMods();
        if (infoList.size() > 1) {
            FrightsDelight.LOGGER.error("Multiple mods for MOD_ID: " + FrightsDelight.MOD_ID);
        }
        for (IModInfo info : infoList) {
            if (info.getModId().equals(FrightsDelight.MOD_ID)) {
                versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
                break;
            }
        }
        return versionString;
    }
}
