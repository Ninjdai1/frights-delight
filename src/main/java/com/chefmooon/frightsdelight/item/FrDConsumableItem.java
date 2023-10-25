package com.chefmooon.frightsdelight.item;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.nhoryzon.mc.farmersdelight.item.ConsumableItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FrDConsumableItem extends ConsumableItem {

    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    public FrDConsumableItem(Settings settings) {
        super(settings);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }
    public FrDConsumableItem(Settings settings, boolean hasFoodEffectTooltip) {
        super(settings);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public FrDConsumableItem(Settings settings, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(settings);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    public void affectConsumer(ItemStack stack, World world, LivingEntity user) {
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (hasCustomTooltip) {
            tooltip.add(FrightsDelight.tooltip("tooltip." + this).formatted(Formatting.BLUE));
        }
        if (hasFoodEffectTooltip) {
            addFoodEffectTooltip(stack, tooltip, 1.f);
        }
    }
}
