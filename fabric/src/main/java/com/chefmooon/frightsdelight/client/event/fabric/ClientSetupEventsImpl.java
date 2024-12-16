package com.chefmooon.frightsdelight.client.event.fabric;

import com.chefmooon.frightsdelight.client.particle.FrightsDelightBubbleParticle;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightEntityTypesImpl;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class ClientSetupEventsImpl {

    public static void registerBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                FrightsDelightBlocksImpl.SOUL_BERRY_BUSH,
                FrightsDelightBlocksImpl.WITHER_BERRY_BUSH,
                FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH,
                FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE,
                FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE,
                FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR,
                FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB,
                FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY,
                FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY);
    }

    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SLIME_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SPIDER_EYE_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.COBWEB_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.GHAST_TEAR_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
    }

    public static void onEntityRendererRegister() {
        EntityRendererRegistry.register(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), ThrownItemRenderer::new);
    }
}
