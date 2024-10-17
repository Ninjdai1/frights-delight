package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.entity.fabric.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEntityTypes;
import com.google.common.base.Suppliers;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class FrightsDelightEntityTypesImpl {
    public static final Supplier<EntityType<BoneShardEntityImpl>> BONE_SHARD = Suppliers.memoize(() ->
            Registry.register(BuiltInRegistries.ENTITY_TYPE, FrightsDelightEntityTypes.BONE_SHARD,
                    FabricEntityTypeBuilder.<BoneShardEntityImpl>create(MobCategory.MISC, BoneShardEntityImpl::new)
                            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                            .trackRangeBlocks(4)
                            .trackedUpdateRate(10).build())
    );

    public static void register() {
    }
}
