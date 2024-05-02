package com.chefmooon.frightsdelight.common.utility;

import net.minecraft.world.effect.MobEffect;

public record MobEffectInfo(MobEffect effect, int duration, Float probability) {
}
