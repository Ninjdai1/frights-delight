package com.chefmooon.frightsdelight.common.registry.fabric;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class FrightsDelightEffectsImpl {

    public static Holder<MobEffect> registerEffect(ResourceLocation location, Supplier<MobEffect> supplier) {
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, location, supplier.get());
    }

    public static void register() {

    }

//    static final List<Holder<?>> EFFECTS = new ArrayList<>();
//
//    public static <T extends MobEffect> Holder<MobEffect> registerEffect(ResourceLocation location, Supplier<T> supplier) {
//        Holder<MobEffect> effect = (Holder<MobEffect>) Registry.register(BuiltInRegistries.MOB_EFFECT, location, supplier.get());
//        var v = Suppliers.memoize(() -> Registry.register(BuiltInRegistries.MOB_EFFECT, location, supplier.get()));
////        EFFECTS.add(v);
//        return effect;
//    }
//
//    public static void register() {
//        EFFECTS.forEach(Holder::value);
//        EFFECTS.clear();
//    }
}
