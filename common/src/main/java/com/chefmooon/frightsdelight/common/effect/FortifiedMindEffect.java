package com.chefmooon.frightsdelight.common.effect;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class FortifiedMindEffect extends MobEffect {
    public FortifiedMindEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x66d0e9);
    }

    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
            if (player.hasEffect(FrightsDelightEffects.HYSTERIA)) {
                player.removeEffect(FrightsDelightEffects.HYSTERIA);
            }
            if (player.hasEffect(FrightsDelightEffects.CHILLS)) {
                player.removeEffect(FrightsDelightEffects.CHILLS);
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
