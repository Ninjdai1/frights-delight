package com.chefmooon.frightsdelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class CobwebbedEffect extends MobEffect {
    private static final double SLOW_FALL_SPEED = -0.05;
    public CobwebbedEffect() {
        super(MobEffectCategory.HARMFUL, 0xe4e9e9);
        this.addAttributeModifier(Attributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.05, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    // TODO work in progress feature
    //public void applyEffectTick(LivingEntity livingEntity, int amplifier) {
    //    if (!livingEntity.getCommandSenderWorld().isClientSide() && livingEntity instanceof Player player) {
    //        Vec3 velocity = player.getDeltaMovement();
    //        if (!player.onGround() && velocity.y < 0) {
    //            AABB playerBox = player.getBoundingBox().inflate(0.05);

    //            BlockPos.betweenClosedStream(playerBox)
    //                    .forEach(pos -> {
    //                        BlockState state = player.level().getBlockState(pos);
    //                        VoxelShape collisionShape = state.getCollisionShape(player.level(), pos).move(pos.getX(), pos.getY(), pos.getZ());
    //                        if (!state.isAir() && state.canOcclude() && !collisionShape.isEmpty()) {
    //                            if (playerBox.intersects(collisionShape.bounds())) {
    //                                FrightsDelight.loggerInfo("TOUCHING!");
    //                                player.setDeltaMovement(player.getDeltaMovement().x, SLOW_FALL_SPEED, player.getDeltaMovement().z);
    //                                return;
    //                            }
    //                        }
    //                    });
    //        }
    //    }
    //}

    //@Override
    //public boolean isDurationEffectTick(int duration, int amplifier) {
    //    return true;
    //}
}
