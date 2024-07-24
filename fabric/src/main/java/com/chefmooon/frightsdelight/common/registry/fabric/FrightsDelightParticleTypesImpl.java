package com.chefmooon.frightsdelight.common.registry.fabric;

import com.google.common.base.Suppliers;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

public class FrightsDelightParticleTypesImpl {
    public static Supplier<SimpleParticleType> registerParticleType(ResourceLocation location) {
        return Suppliers.memoize(() -> Registry.register(BuiltInRegistries.PARTICLE_TYPE, location, FabricParticleTypes.simple(true)));
    }

    public static void register() {

    }
}
