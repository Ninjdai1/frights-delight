package com.chefmooon.frightsdelight.common.neoforge;

import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupImpl {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
//            CommonSetup.init();
            registerDispenserBehaviors();
        });

//        CraftingHelper.register(new FrDVanillaCrateEnabledConditionImpl.Serializer());
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerProjectileBehavior(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD));
    }
}
