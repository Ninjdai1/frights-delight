package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class FrightsDelightEffectsImpl {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, FrightsDelight.MOD_ID);

    public static <T extends MobEffect> Supplier<T> registerEffect(ResourceLocation location, Supplier<T> supplier) {
        return MOB_EFFECTS.register(location.getPath(), supplier);
    }

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
