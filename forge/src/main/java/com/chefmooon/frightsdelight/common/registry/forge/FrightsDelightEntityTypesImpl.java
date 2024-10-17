package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.entity.forge.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEntityTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FrightsDelightEntityTypesImpl {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FrightsDelight.MOD_ID);

    public static final RegistryObject<EntityType<BoneShardEntityImpl>> BONE_SHARD = ENTITIES.register(FrightsDelightEntityTypes.BONE_SHARD.getPath(), () -> (
            EntityType.Builder.<BoneShardEntityImpl>of(BoneShardEntityImpl::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build(FrightsDelightEntityTypes.BONE_SHARD.getPath())));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
