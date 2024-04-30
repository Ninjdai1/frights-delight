package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class FrightsDelightSoundsImpl {
    public static final LazyRegistrar<SoundEvent> SOUNDS = LazyRegistrar.create(BuiltInRegistries.SOUND_EVENT, FrightsDelight.MOD_ID);

    public static <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> supplier) {
        return SOUNDS.register(id, supplier);
    }
}
