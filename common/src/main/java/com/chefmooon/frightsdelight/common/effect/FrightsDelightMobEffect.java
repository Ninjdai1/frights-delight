package com.chefmooon.frightsdelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.Optional;
import java.util.function.Supplier;

public class FrightsDelightMobEffect extends MobEffect {
    private final Supplier<MobEffectInstance.FactorData> factorDataFactory = () -> new MobEffectInstance.FactorData(100);

    protected FrightsDelightMobEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public Optional<MobEffectInstance.FactorData> createFactorData() {
        return Optional.ofNullable((MobEffectInstance.FactorData)this.factorDataFactory.get());
    }
}
