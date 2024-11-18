package com.chefmooon.frightsdelight.common.world.placement.neoforge;

import com.chefmooon.frightsdelight.common.registry.neoforge.FrightsDelightPlacementModifiersImpl;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class BiomeIsNetherPlacementModifier extends PlacementFilter {
    private static final BiomeIsNetherPlacementModifier INSTANCE = new BiomeIsNetherPlacementModifier();
    public static final MapCodec<BiomeIsNetherPlacementModifier> CODEC = MapCodec.unit(INSTANCE);

    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return context.getLevel().getBiome(pos).is(BiomeTags.IS_NETHER);
    }

    @Override
    public PlacementModifierType<?> type() {
        return FrightsDelightPlacementModifiersImpl.BIOME_TAG.get();
    }
}
