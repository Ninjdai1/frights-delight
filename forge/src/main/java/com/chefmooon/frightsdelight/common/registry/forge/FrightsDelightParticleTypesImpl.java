package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class FrightsDelightParticleTypesImpl {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, FrightsDelight.MOD_ID);

    public static Supplier<SimpleParticleType> registerParticleType(ResourceLocation location) {
        return PARTICLE_TYPES.register(location.getPath(), () -> new SimpleParticleType(true));
    }

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
