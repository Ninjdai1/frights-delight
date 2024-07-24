package com.chefmooon.frightsdelight.common.world.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public record WildBushConfiguration(int tries, int xzSpread, int ySpread, Holder<PlacedFeature> primaryFeature, Holder<PlacedFeature> secondaryFeature, @Nullable Holder<PlacedFeature> floorFeature
) implements FeatureConfiguration
{
    public static final Codec<WildBushConfiguration> CODEC = RecordCodecBuilder.create((config) -> config.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(64).forGetter(WildBushConfiguration::tries),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("xz_spread").orElse(4).forGetter(WildBushConfiguration::xzSpread),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("y_spread").orElse(3).forGetter(WildBushConfiguration::ySpread),
            PlacedFeature.CODEC.fieldOf("primary_feature").forGetter(WildBushConfiguration::primaryFeature),
            PlacedFeature.CODEC.fieldOf("secondary_feature").forGetter(WildBushConfiguration::secondaryFeature),
            PlacedFeature.CODEC.optionalFieldOf("floor_feature").forGetter(floorConfig -> Optional.ofNullable(floorConfig.floorFeature))
    ).apply(config, (tries, xzSpread, yspread, primary, secondary, floor) -> floor.map(placedFeatureHolder -> new WildBushConfiguration(tries, xzSpread, yspread, primary, secondary, placedFeatureHolder)).orElseGet(() -> new WildBushConfiguration(tries, xzSpread, yspread, primary, secondary, null))));

    public WildBushConfiguration(int tries, int xzSpread, int ySpread, Holder<PlacedFeature> primaryFeature, Holder<PlacedFeature> secondaryFeature, @Nullable Holder<PlacedFeature> floorFeature) {
        this.tries = tries;
        this.xzSpread = xzSpread;
        this.ySpread = ySpread;
        this.primaryFeature = primaryFeature;
        this.secondaryFeature = secondaryFeature;
        this.floorFeature = floorFeature;
    }

    public int tries() {
        return this.tries;
    }

    public int xzSpread() {
        return this.xzSpread;
    }

    public int ySpread() {
        return this.ySpread;
    }

    public Holder<PlacedFeature> primaryFeature() {
        return this.primaryFeature;
    }

    public Holder<PlacedFeature> secondaryFeature() {
        return this.secondaryFeature;
    }

    public Holder<PlacedFeature> floorFeature() {
        return this.floorFeature;
    }
}
