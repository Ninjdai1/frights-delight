package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class FrightsDelightParticleTypes {

    public static final Supplier<SimpleParticleType> SLIME_BUBBLE = registerParticleType("slime_bubble");
    //public static final Supplier<SimpleParticleType> SLIME_POP = registerParticleType("slime_pop");

    private static Supplier<SimpleParticleType> registerParticleType(String string) {
        return registerParticleType(TextUtils.res(string));
    }

    @ExpectPlatform
    public static Supplier<SimpleParticleType> registerParticleType(ResourceLocation location) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
