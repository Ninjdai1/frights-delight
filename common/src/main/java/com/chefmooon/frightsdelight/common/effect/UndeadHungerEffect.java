package com.chefmooon.frightsdelight.common.effect;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class UndeadHungerEffect extends MobEffect {
    public UndeadHungerEffect() {
        super(MobEffectCategory.NEUTRAL, 0x6f4d1b);
    }

    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
            if (player.hasEffect(FrightsDelightEffects.INFECTED)) {
                player.removeEffect(FrightsDelightEffects.INFECTED);
            }
            if (player.hasEffect(MobEffects.HUNGER)) {
                player.removeEffect(MobEffects.HUNGER);
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
