package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class FrightsDelightParticleTypes {

    public static final Supplier<SimpleParticleType> SLIME_BUBBLE = registerParticleType("slime_bubble");
    public static final Supplier<SimpleParticleType> ROTTEN_FLESH_BUBBLE = registerParticleType("rotten_flesh_bubble");
    public static final Supplier<SimpleParticleType> SPIDER_EYE_BUBBLE = registerParticleType("spider_eye_bubble");
    public static final Supplier<SimpleParticleType> SOUL_BERRY_BUBBLE = registerParticleType("soul_berry_bubble");
    public static final Supplier<SimpleParticleType> WITHER_BERRY_BUBBLE = registerParticleType("wither_berry_bubble");
    public static final Supplier<SimpleParticleType> COBWEB_BUBBLE = registerParticleType("cobweb_bubble");
    public static final Supplier<SimpleParticleType> GHAST_TEAR_BUBBLE = registerParticleType("ghast_tear_bubble");

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
