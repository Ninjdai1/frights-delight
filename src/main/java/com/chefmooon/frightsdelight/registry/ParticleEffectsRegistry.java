package com.chefmooon.frightsdelight.registry;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public enum ParticleEffectsRegistry {

    SLIME_BUBBLE("slime_bubble"),
    SLIME_BUBBLE_POP("slime_bubble_pop")
    ;
    private final String pathName;
    private final DefaultParticleType defaultParticleType;

    ParticleEffectsRegistry(String pathName) {
        this.pathName = pathName;
        this.defaultParticleType = FabricParticleTypes.simple();
    }

    public static void registerAll() {
        for (ParticleEffectsRegistry value : values()) {
            Registry.register(Registries.PARTICLE_TYPE, new Identifier(FrightsDelight.MOD_ID, value.pathName), value.get());
        }
    }

    public DefaultParticleType get() {
        return defaultParticleType;
    }
}
