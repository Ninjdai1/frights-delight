package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.entity.neoforge.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEntityTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class FrightsDelightEntityTypesImpl {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, FrightsDelight.MOD_ID);

    public static final Supplier<EntityType<BoneShardEntityImpl>> BONE_SHARD = ENTITIES.register(FrightsDelightEntityTypes.BONE_SHARD.getPath(), () -> (
            EntityType.Builder.<BoneShardEntityImpl>of(BoneShardEntityImpl::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(FrightsDelightEntityTypes.BONE_SHARD.getPath())));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
