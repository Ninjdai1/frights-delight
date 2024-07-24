package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightPlacementModifiers;
import com.chefmooon.frightsdelight.common.world.placement.forge.BiomeIsNetherPlacementModifier;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class FrightsDelightPlacementModifiersImpl {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE.key(), FrightsDelight.MOD_ID);

    public static final RegistryObject<PlacementModifierType<BiomeIsNetherPlacementModifier>> BIOME_TAG = PLACEMENT_MODIFIERS.register(FrightsDelightPlacementModifiers.BIOME_IS_NETHER.getPath(), () -> typeConvert(BiomeIsNetherPlacementModifier.CODEC));

    private static <P extends PlacementModifier> PlacementModifierType<P> typeConvert(Codec<P> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        PLACEMENT_MODIFIERS.register(eventBus);
    }
}
