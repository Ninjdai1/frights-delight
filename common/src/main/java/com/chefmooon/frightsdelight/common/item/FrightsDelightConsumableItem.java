package com.chefmooon.frightsdelight.common.item;

import com.chefmooon.frightsdelight.common.Configuration;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.List;

public class FrightsDelightConsumableItem extends ConsumableItem {
    public FrightsDelightConsumableItem(Properties properties) {
        super(properties);
    }

    public FrightsDelightConsumableItem(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    public FrightsDelightConsumableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if ((Boolean) Configuration.foodEffectTooltip()) {
            super.appendHoverText(stack, level, tooltip, isAdvanced);
        }
    }
}
