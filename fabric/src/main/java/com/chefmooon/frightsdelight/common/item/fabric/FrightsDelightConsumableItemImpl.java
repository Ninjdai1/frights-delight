package com.chefmooon.frightsdelight.common.item.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Deprecated(forRemoval = true)
public class FrightsDelightConsumableItemImpl extends ConsumableItem {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;

    public FrightsDelightConsumableItemImpl(Properties properties) {
        super(properties);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }
    public FrightsDelightConsumableItemImpl(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }
    public FrightsDelightConsumableItemImpl(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltip, isAdvanced);
        if (Configuration.foodEffectTooltip()) {
            if (this.hasCustomTooltip) {
                tooltip.add(FrightsDelight.tooltip("tooltip." + this).withStyle(ChatFormatting.BLUE));
            }
            if (this.hasFoodEffectTooltip) {
                if ((Boolean) Configuration.foodEffectChanceTooltip()) {
                    TextUtils.addFoodEffectTooltipWithDetail(stack, tooltip, 1.0F);
                } else {
                    TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
                }
            }
        }
    }
}
