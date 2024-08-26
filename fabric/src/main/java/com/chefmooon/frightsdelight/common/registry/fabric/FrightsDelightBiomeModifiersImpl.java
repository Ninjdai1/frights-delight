package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBiomeModifiers;
import com.chefmooon.frightsdelight.common.tag.FrightsDelightTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class FrightsDelightBiomeModifiersImpl {
    public static final ResourceKey<PlacedFeature> WILD_SOUL_BERRY_BUSH = modFeature(FrightsDelightBiomeModifiers.PATCH_WILD_SOUL_BERRY_BUSHES);

    @NotNull
    private static ResourceKey<PlacedFeature> modFeature(ResourceLocation location) {
        return ResourceKey.create(Registries.PLACED_FEATURE, location);
    }

    public static void init() {
        if ((Boolean) Configuration.generateWildSoulBerry()) {
            BiomeModifications.addFeature(new FrDBiomeSelector(FrightsDelightTags.WILD_SOUL_BERRY_BUSH_WHITELIST, FrightsDelightTags.WILD_SOUL_BERRY_BUSH_BLACKLIST),
                    GenerationStep.Decoration.VEGETAL_DECORATION, WILD_SOUL_BERRY_BUSH);
        }
    }

    public record FrDBiomeSelector(TagKey<Biome> allowed, TagKey<Biome> denied) implements Predicate<BiomeSelectionContext> {
        @Override
        public boolean test(BiomeSelectionContext context) {
            Holder<Biome> biome = context.getBiomeRegistryEntry();
            return biome.is(allowed) && !biome.is(denied);
        }
    }
}
