package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrightsDelight {
    public static final String MOD_ID = "frightsdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static MutableComponent tooltip(String key, Object... args) {
        return Component.translatable(MOD_ID + "." + key, args);
    }
    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static void init() {
        FrightsDelightSounds.init();
        FrightsDelightEffects.init();
        FrightsDelightParticleTypes.init();
        Configuration.init();
    }
    @ExpectPlatform
    public static void loggerInfo(String s) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String findVersion() {
        throw new AssertionError();
    }

}
