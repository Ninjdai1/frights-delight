package com.chefmooon.frightsdelight.effect;

import com.chefmooon.frightsdelight.registry.SoundsRegistry;
import com.chefmooon.frightsdelight.registry.StatusEffectsRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;

import java.util.List;
import java.util.Random;

public class HysteriaEffect extends StatusEffect {
    private static List<SoundEvent> SOUNDS = List.of(SoundEvents.ENTITY_SKELETON_AMBIENT, SoundEvents.ENTITY_ZOMBIE_AMBIENT, SoundEvents.ENTITY_SPIDER_AMBIENT);
    public HysteriaEffect(int color) {
        super(StatusEffectCategory.HARMFUL, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        //TODO: Question is this happening on client or server? can other players hear it?
        //TODO: Do we check if the block is air?
        if (entity instanceof PlayerEntity player) {
            if (!player.hasStatusEffect(StatusEffectsRegistry.FORTIFIED_MIND.get())) {
                Random random = new Random();
                int soundChance = 200 - player.getHungerManager().getFoodLevel() * 5;
                if (random.nextInt(soundChance) == 0) {
                    int distance = random.nextInt(3);
                    Vec3d pos = player.getPos();
                    if (distance == 0) { // close
                        double range = 4;
                        double dx = pos.getX() + ((random.nextDouble() * range) - range / 2);
                        double dy = pos.getY() + 1;
                        double dz = pos.getZ() + ((random.nextDouble() * range) - range / 2);
                        //FrightsDelight.LOGGER.info("close - " + soundEvent.getId() + " x: " + dx + " z: " + dz);
                        player.getWorld().playSound(dx, dy, dz, SoundsRegistry.EFFECT_HYSTERIA_CLOSE.get(), SoundCategory.HOSTILE, 0.2f, 0.6f, false);
                    } else if (distance == 1) { // mid
                        double range = 8;
                        double dx = pos.getX() + ((random.nextDouble() * range) - range / 2);
                        double dy = pos.getY() + 1;
                        double dz = pos.getZ() + ((random.nextDouble() * range) - range / 2);
                        //FrightsDelight.LOGGER.info("mid - " + soundEvent.getId() + " x: " + dx + " z: " + dz);
                        player.getWorld().playSound(dx, dy, dz, SoundsRegistry.EFFECT_HYSTERIA_MID.get(), SoundCategory.HOSTILE, 0.2f, 0.6f, false);
                    } else { // far
                        double range = 16;
                        double dx = pos.getX() + ((random.nextDouble() * range) - range / 2);
                        double dy = pos.getY() + 1;
                        double dz = pos.getZ() + ((random.nextDouble() * range) - range / 2);
                        //FrightsDelight.LOGGER.info("far - " + soundEvent.getId() + " x: " + dx + " z: " + dz);
                        player.getWorld().playSound(dx, dy, dz, SoundsRegistry.EFFECT_HYSTERIA_FAR.get(), SoundCategory.HOSTILE, 0.2f, 0.6f, false);
                    }
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int tickDuration, int amplifier) {
        return true;
    }
}
