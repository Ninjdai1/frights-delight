package com.chefmooon.frightsdelight.common.item;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrightsDelightConsumableItemNameBlockItem extends ItemNameBlockItem {
    private final boolean hasFoodEffectTooltip;
    public FrightsDelightConsumableItemNameBlockItem(Block block, Properties properties) {
        super(block, properties);
        this.hasFoodEffectTooltip = false;
    }
    public FrightsDelightConsumableItemNameBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip) {
        super(block, properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, context, tooltip, isAdvanced);
        if ((Boolean) Configuration.foodEffectTooltip()) {
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
