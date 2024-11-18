package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import dev.architectury.injectables.annotations.ExpectPlatform;

public class FrightsDelight {
    public static final String MOD_ID = "frightsdelight";

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
