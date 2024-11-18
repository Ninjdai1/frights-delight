package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.crafting.condition.neoforge.FrDVanillaCrateEnabledConditionImpl;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class FrightsDelightConditionCodecsImpl {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS = DeferredRegister.create(NeoForgeRegistries.CONDITION_SERIALIZERS, FrightsDelight.MOD_ID);
    public static final Supplier<MapCodec<? extends ICondition>> FRD_CRATES_ENABLED = CONDITION_CODECS.register("frd_vanilla_crates_enabled", () -> FrDVanillaCrateEnabledConditionImpl.CODEC);

    public static void register(IEventBus eventBus) {
        CONDITION_CODECS.register(eventBus);
    }
}
