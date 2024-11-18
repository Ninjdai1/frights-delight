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
                EntityType.Builder.<BoneShardEntityImpl>of(BoneShardEntityImpl::new, MobCategory.MISC)
                        .sized(0.25F, 0.25F)
                        .clientTrackingRange(4)
                        .updateInterval(10)
                        .build(FrightsDelightEntityTypes.BONE_SHARD.getPath())));

    public static void register() {
    }
}
