package com.chefmooon.frightsdelight.client.event.fabric;

import com.chefmooon.frightsdelight.client.particle.FrightsDelightBubbleParticle;
import com.chefmooon.frightsdelight.client.particle.SlimeBubbleParticle;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class ClientSetupEventsImpl {

    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SLIME_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.ROTTEN_FLESH_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SPIDER_EYE_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SOUL_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.WITHER_BERRY_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.COBWEB_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.GHAST_TEAR_BUBBLE.get(), FrightsDelightBubbleParticle.Factory::new);
    }
}
