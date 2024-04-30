package com.chefmooon.frightsdelight.common.mixin.accessor.fabric;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(LootContext.class)
public interface LootContextAccessorImpl {
    @Accessor("params")
    LootParams getParams();
}
