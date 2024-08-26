package com.chefmooon.frightsdelight.common.world.placement.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightPlacementModifiersImpl;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class BiomeIsNetherPlacementModifier extends PlacementFilter {
    private static final BiomeIsNetherPlacementModifier INSTANCE = new BiomeIsNetherPlacementModifier();
    public static final Codec<BiomeIsNetherPlacementModifier> CODEC = Codec.unit(INSTANCE);

    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return context.getLevel().getBiome(pos).is(BiomeTags.IS_NETHER);
    }

    @Override
    public PlacementModifierType<?> type() {
        return FrightsDelightPlacementModifiersImpl.BIOME_IS_NETHER;
    }
}
