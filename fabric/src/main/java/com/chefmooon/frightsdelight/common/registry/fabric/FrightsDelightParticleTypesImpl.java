package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.google.common.base.Suppliers;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class FrightsDelightParticleTypesImpl {
    public static Supplier<SimpleParticleType> registerParticleType(String id) {
        return Suppliers.memoize(() -> Registry.register(BuiltInRegistries.PARTICLE_TYPE, FrightsDelight.res(id), FabricParticleTypes.simple(true)));
    }

    public static void register() {

    }
}
