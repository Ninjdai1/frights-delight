package com.chefmooon.frightsdelight.common.utility;

import net.minecraft.world.effect.MobEffect;

public class MobEffectInfo {
    private final MobEffect effect;
    private final int duration;
    private final Float probability;

    public MobEffectInfo(MobEffect effect, int duration, Float probability) {
        this.effect = effect;
        this.duration = duration;
        this.probability = probability;
    }

    public Float getProbability() {
        return probability;
    }

    public int getDuration() {
        return duration;
    }

    public MobEffect getEffect() {
        return effect;
    }
}
