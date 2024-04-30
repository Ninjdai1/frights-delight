package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class FrightsDelightSoundsImpl {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FrightsDelight.MOD_ID);

    public static <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> supplier) {
        return SOUND_EVENTS.register(id, supplier);
    }
}
