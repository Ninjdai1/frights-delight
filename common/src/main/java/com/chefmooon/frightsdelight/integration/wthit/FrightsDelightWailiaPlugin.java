package com.chefmooon.frightsdelight.integration.wthit;

import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.FrightsDelightBushBlock;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.integration.wthit.provider.BerryBushInfoProvider;
import com.chefmooon.frightsdelight.integration.wthit.provider.DrinkableFeastProvider;
import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import net.minecraft.resources.ResourceLocation;

public class FrightsDelightWailiaPlugin implements IWailaPlugin {
    public static class Options {
        public static final ResourceLocation CROP_PROGRESS = ResourceLocation.parse("crop_progress");
        public static final ResourceLocation BUSH_GROWTH_CONDITION = TextUtils.res("bush_growth_condition");
        public static final ResourceLocation BUSH_TRANSFORM_CONDITION = TextUtils.res("bush_transform_condition");
        public static final ResourceLocation PUNCHBOWL_SERVINGS = TextUtils.res("punchbowl_servings");
    }

    @Override
    public void register(IRegistrar registrar) {
        registrar.addConfig(Options.BUSH_GROWTH_CONDITION, true);
        registrar.addConfig(Options.BUSH_TRANSFORM_CONDITION, true);
        registrar.addConfig(Options.PUNCHBOWL_SERVINGS, true);

        registrar.addComponent(BerryBushInfoProvider.INSTANCE, TooltipPosition.BODY, FrightsDelightBushBlock.class);
        registrar.addComponent(DrinkableFeastProvider.INSTANCE, TooltipPosition.BODY, DrinkableFeastBlock.class);
    }
}
