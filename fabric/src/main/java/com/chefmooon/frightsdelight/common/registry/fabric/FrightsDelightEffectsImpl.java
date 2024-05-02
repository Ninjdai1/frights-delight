package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class FrightsDelightEffectsImpl {
    public static final LazyRegistrar<MobEffect> MOB_EFFECTS = LazyRegistrar.create(BuiltInRegistries.MOB_EFFECT, FrightsDelight.MOD_ID);

    public static <T extends MobEffect> Supplier<T> registerEffect(String id, Supplier<T> supplier) {
        return MOB_EFFECTS.register(id, supplier);
    }
}
