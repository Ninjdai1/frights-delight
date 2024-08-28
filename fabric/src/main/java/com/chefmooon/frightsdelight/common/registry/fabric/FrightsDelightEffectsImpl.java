package com.chefmooon.frightsdelight.common.registry.fabric;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class FrightsDelightEffectsImpl {
    static final List<Supplier<?>> EFFECTS = new ArrayList<>();

    public static <T extends MobEffect> Supplier<T> registerEffect(ResourceLocation location, Supplier<T> supplier) {
        var v = Suppliers.memoize(() -> Registry.register(BuiltInRegistries.MOB_EFFECT, location, supplier.get()));
        EFFECTS.add(v);
        return v;
    }

    public static void register() {
        EFFECTS.forEach(Supplier::get);
        EFFECTS.clear();
    }
}