package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class FrightsDelightSoundsImpl {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FrightsDelight.MOD_ID);

    public static <T extends SoundEvent> Supplier<T> registerSound(ResourceLocation id, Supplier<T> supplier) {
        return SOUND_EVENTS.register(id.getPath(), supplier);
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
