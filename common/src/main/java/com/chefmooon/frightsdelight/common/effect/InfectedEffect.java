package com.chefmooon.frightsdelight.common.effect;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class InfectedEffect extends MobEffect {
    public InfectedEffect() {
        super(MobEffectCategory.HARMFUL, 0x4f8c29);
    }

    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (livingEntity.hasEffect(FrightsDelightEffects.UNDEAD_HUNGER.get())) {
            return;
        }
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
            if (player.hasEffect(MobEffects.HUNGER)) {
                player.removeEffect(MobEffects.HUNGER);
            }
            ((Player)livingEntity).causeFoodExhaustion(0.01F * (float)(amplifier + 1));
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
