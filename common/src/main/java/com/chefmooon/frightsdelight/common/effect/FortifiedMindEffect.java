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

    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
        if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
            if (player.hasEffect(FrightsDelightEffects.HYSTERIA.get())) {
                player.removeEffect(FrightsDelightEffects.HYSTERIA.get());
            }
            if (player.hasEffect(FrightsDelightEffects.CHILLS.get())) {
                player.removeEffect(FrightsDelightEffects.CHILLS.get());
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
