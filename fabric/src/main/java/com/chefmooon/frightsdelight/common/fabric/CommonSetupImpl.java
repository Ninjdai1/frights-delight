package com.chefmooon.frightsdelight.common.fabric;

import com.chefmooon.frightsdelight.common.CommonSetup;
import com.chefmooon.frightsdelight.common.crafting.condition.fabric.FrDVanillaCrateEnabledConditionImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.DispenserBlock;

public class CommonSetupImpl {

    public static void init() {
//        CommonSetup.init();
        CommonSetup.registerCompostables();
        registerDispenserBehaviors();

        ResourceConditions.register(FrDVanillaCrateEnabledConditionImpl.TYPE);
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerProjectileBehavior(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD));
    }
}
