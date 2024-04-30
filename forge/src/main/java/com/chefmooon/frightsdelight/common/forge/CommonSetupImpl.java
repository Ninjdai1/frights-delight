package com.chefmooon.frightsdelight.common.forge;

import com.chefmooon.frightsdelight.common.CommonSetup;
import com.chefmooon.frightsdelight.common.crafting.condition.forge.FrDVanillaCrateEnabledConditionImpl;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupImpl {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CommonSetup.init();
        });

        CraftingHelper.register(new FrDVanillaCrateEnabledConditionImpl.Serializer());
    }
}
