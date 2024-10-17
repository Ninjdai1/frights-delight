package com.chefmooon.frightsdelight.common.forge;

import com.chefmooon.frightsdelight.common.CommonSetup;
import com.chefmooon.frightsdelight.common.crafting.condition.forge.FrDVanillaCrateEnabledConditionImpl;
import com.chefmooon.frightsdelight.common.entity.forge.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.AbstractProjectileDispenseBehavior;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupImpl {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CommonSetup.init();
            registerDispenserBehaviors();
        });

        CraftingHelper.register(new FrDVanillaCrateEnabledConditionImpl.Serializer());
    }

    public static void registerDispenserBehaviors() {
        DispenserBlock.registerBehavior(BuiltInRegistries.ITEM.get(FrightsDelightItems.BONE_SHARD), new AbstractProjectileDispenseBehavior() {
            @Override
            protected Projectile getProjectile(Level level, Position position, ItemStack stack) {
                return new BoneShardEntityImpl(level, position.x(), position.y(), position.z());
            }
        });
    }
}
