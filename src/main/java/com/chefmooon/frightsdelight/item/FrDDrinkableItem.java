package com.chefmooon.frightsdelight.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FrDDrinkableItem extends FrDConsumableItem{
    private final SoundEvent consumeSound;
    private final int consumeSoundChance;
    public FrDDrinkableItem(Settings settings) {
        super(settings);
        this.consumeSound = null;
        this.consumeSoundChance = 0;
    }
    public FrDDrinkableItem(Settings settings, SoundEvent consumeSound, int consumeSoundChance, boolean hasFoodEffectTooltip) {
        super(settings, hasFoodEffectTooltip);
        this.consumeSound = consumeSound;
        this.consumeSoundChance = consumeSoundChance;
    }
    public FrDDrinkableItem(Settings settings, boolean hasFoodEffectTooltip) {
        super(settings, hasFoodEffectTooltip);
        this.consumeSound = null;
        this.consumeSoundChance = 0;
    }

    public FrDDrinkableItem(Settings settings, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(settings, hasFoodEffectTooltip, hasCustomTooltip);
        this.consumeSound = null;
        this.consumeSoundChance = 0;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack heldStack = user.getStackInHand(hand);
        if (heldStack.isFood()) {
            if (user.canConsume(heldStack.getItem().getFoodComponent().isAlwaysEdible())) {
                user.setCurrentHand(hand);
                if (consumeSound != null) {
                    if (new Random().nextInt(consumeSoundChance) == 0) { // 4 = 25% chance of sound on consume
                        BlockPos pos = new BlockPos((int) user.getX(), (int) user.getY(), (int) user.getZ());
                        world.playSound((PlayerEntity)null, pos, consumeSound, SoundCategory.HOSTILE, 0.5F, 0.8F + world.random.nextFloat() * 0.4F);
                    }
                }
                return TypedActionResult.consume(heldStack);
            } else {
                return TypedActionResult.fail(heldStack);
            }
        }

        return ItemUsage.consumeHeldItem(world, user, hand);
    }
}
