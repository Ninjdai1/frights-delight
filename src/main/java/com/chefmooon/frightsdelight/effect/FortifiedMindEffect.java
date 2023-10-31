package com.chefmooon.frightsdelight.effect;

import com.chefmooon.frightsdelight.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class FortifiedMindEffect extends StatusEffect {
    public FortifiedMindEffect(int color) {
        super(StatusEffectCategory.BENEFICIAL, color);

    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            if (player.hasStatusEffect(StatusEffectsRegistry.HYSTERIA.get())) {
                player.removeStatusEffect(StatusEffectsRegistry.HYSTERIA.get());
            } else if (player.hasStatusEffect(StatusEffectsRegistry.CHILLS.get())) {
                player.removeStatusEffect(StatusEffectsRegistry.CHILLS.get());
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int tickDuration, int amplifier) {
        return true;
    }
}
