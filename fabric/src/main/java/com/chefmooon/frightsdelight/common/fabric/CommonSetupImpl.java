package com.chefmooon.frightsdelight.common.fabric;

import com.chefmooon.frightsdelight.common.CommonSetup;
import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.crafting.condition.FrDVanillaCrateEnabledCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;

public class CommonSetupImpl {

    public static void init() {
        CommonSetup.init();

        ResourceConditions.register(FrDVanillaCrateEnabledCondition.ID, jsonObject -> Configuration.isEnableFrDCrates());
    }
}
