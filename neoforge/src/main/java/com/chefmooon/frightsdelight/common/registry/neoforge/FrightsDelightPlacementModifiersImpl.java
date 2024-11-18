package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightPlacementModifiers;
import com.chefmooon.frightsdelight.common.world.placement.neoforge.BiomeIsNetherPlacementModifier;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FrightsDelightPlacementModifiersImpl {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE.key(), FrightsDelight.MOD_ID);

    public static final Supplier<PlacementModifierType<BiomeIsNetherPlacementModifier>> BIOME_TAG = PLACEMENT_MODIFIERS.register(FrightsDelightPlacementModifiers.BIOME_IS_NETHER.getPath(), () -> typeConvert(BiomeIsNetherPlacementModifier.CODEC));

    private static <P extends PlacementModifier> PlacementModifierType<P> typeConvert(MapCodec<P> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        PLACEMENT_MODIFIERS.register(eventBus);
    }
}
