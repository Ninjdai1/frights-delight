package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class FrightsDelightParticleTypesImpl {
    public static final LazyRegistrar<ParticleType<?>> PARTICLE_TYPES = LazyRegistrar.create(BuiltInRegistries.PARTICLE_TYPE, FrightsDelight.MOD_ID);

    public static Supplier<SimpleParticleType> registerParticleType(String id) {
        return PARTICLE_TYPES.register(id, () -> FabricParticleTypes.simple(true));
    }
}
