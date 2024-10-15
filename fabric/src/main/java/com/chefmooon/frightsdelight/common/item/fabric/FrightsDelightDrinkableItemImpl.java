package com.chefmooon.frightsdelight.common.item.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.Configuration;
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

@Deprecated(forRemoval = true)
public class FrightsDelightDrinkableItemImpl extends FrightsDelightConsumableItemImpl {
    private final SoundEvent consumeSound;
    private final int defaultConsumeSoundChance = 4; // 25%
    public FrightsDelightDrinkableItemImpl(Properties properties) {
        super(properties);
        this.consumeSound = null;
    }

    public FrightsDelightDrinkableItemImpl(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
        this.consumeSound = null;
    }

    public FrightsDelightDrinkableItemImpl(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasFoodEffectTooltip, hasCustomTooltip);
        this.consumeSound = null;
    }

    public FrightsDelightDrinkableItemImpl(Properties settings, SoundEvent consumeSound, boolean hasFoodEffectTooltip) {
        super(settings, hasFoodEffectTooltip);
        this.consumeSound = consumeSound;
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
                if (Configuration.punchConsumeSound() && consumeSound != null) {
                    // TODO : after testing decide if null check is needed, if not remove defaultConsumeSoundChance
                    if (new Random().nextInt(Configuration.punchConsumeChance()) == 0) { // 4 = 25% chance of sound on consume
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
