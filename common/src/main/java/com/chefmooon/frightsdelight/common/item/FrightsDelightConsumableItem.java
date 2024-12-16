package com.chefmooon.frightsdelight.common.item;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class FrightsDelightConsumableItem extends ConsumableItem {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    public FrightsDelightConsumableItem(Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public FrightsDelightConsumableItem(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public FrightsDelightConsumableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.foodEffectTooltip()) {
            if (this.hasCustomTooltip) {
                tooltip.add(TextUtils.getTranslatable("tooltip." + this).withStyle(ChatFormatting.BLUE));
            }
            if (this.hasFoodEffectTooltip) {
                if ((Boolean) Configuration.foodEffectChanceTooltip()) {
                    TextUtils.addFoodEffectTooltipWithDetail(stack, tooltip::add, 1.0F, context.tickRate());
                } else {
                    TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
                }
            }
        }
    }
}
