package com.chefmooon.frightsdelight.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.Random;

public class FrightsDelightDrinkableItem extends FrightsDelightConsumableItem {
    private final SoundEvent consumeSound;
    private final int consumeSoundChance;
    public FrightsDelightDrinkableItem(Properties properties) {
        super(properties);
        this.consumeSound = null;
        this.consumeSoundChance = 0;
    }
    public FrightsDelightDrinkableItem(Properties settings, boolean hasFoodEffectTooltip) {
        super(settings, hasFoodEffectTooltip);
        this.consumeSound = null;
        this.consumeSoundChance = 0;
    }
    public FrightsDelightDrinkableItem(Properties settings, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(settings, hasFoodEffectTooltip, hasCustomTooltip);
        this.consumeSound = null;
        this.consumeSoundChance = 0;
    }
    public FrightsDelightDrinkableItem(Properties settings, SoundEvent consumeSound, int consumeSoundChance, boolean hasFoodEffectTooltip) {
        super(settings, hasFoodEffectTooltip);
        this.consumeSound = consumeSound;
        this.consumeSoundChance = consumeSoundChance;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        if (heldStack.isEdible()) {
            if (player.canEat(heldStack.getItem().getFoodProperties().canAlwaysEat())) {
                player.startUsingItem(hand);
                if (consumeSound != null) {
                    if (new Random().nextInt(consumeSoundChance) == 0) { // 4 = 25% chance of sound on consume
                        BlockPos pos = new BlockPos((int) player.getX(), (int) player.getY(), (int) player.getZ());
                        level.playSound((Player)null, pos, consumeSound, SoundSource.HOSTILE, 0.5F, 0.8F + level.random.nextFloat() * 0.4F);
                    }
                }
                return InteractionResultHolder.consume(heldStack);
            } else {
                return InteractionResultHolder.fail(heldStack);
            }
        }
        return ItemUtils.startUsingInstantly(level, player, hand);
    }
}
