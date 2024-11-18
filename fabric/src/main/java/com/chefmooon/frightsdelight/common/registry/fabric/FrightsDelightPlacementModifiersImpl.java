package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightPlacementModifiers;
import com.chefmooon.frightsdelight.common.world.placement.fabric.BiomeIsNetherPlacementModifier;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class FrightsDelightPlacementModifiersImpl {
    public static final PlacementModifierType<? extends PlacementModifier> BIOME_IS_NETHER = registerBiomeTag(FrightsDelightPlacementModifiers.BIOME_IS_NETHER, BiomeIsNetherPlacementModifier.CODEC);

    public static PlacementModifierType<? extends PlacementModifier> registerBiomeTag(ResourceLocation location, MapCodec<? extends PlacementModifier> codec) {
        return Registry.register(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE, location, typeConvert(codec));
    }

    private static <P extends PlacementModifier> PlacementModifierType<P> typeConvert(MapCodec<P> codec) {
        return () -> codec;
    }

    public static void register() {

    }
}
