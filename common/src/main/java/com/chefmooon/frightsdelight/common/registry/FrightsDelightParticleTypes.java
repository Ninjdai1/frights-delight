package com.chefmooon.frightsdelight.common.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Supplier;

public class FrightsDelightParticleTypes {

    public static final Supplier<SimpleParticleType> SLIME_BUBBLE = registerParticleType("slime_bubble");
    //public static final Supplier<SimpleParticleType> SLIME_POP = registerParticleType("slime_pop");

    @ExpectPlatform
    public static Supplier<SimpleParticleType> registerParticleType(String id) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
