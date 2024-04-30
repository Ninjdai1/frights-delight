package com.chefmooon.frightsdelight.client.event.fabric;

import com.chefmooon.frightsdelight.client.particle.SlimeBubbleParticle;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightParticleTypes;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class ClientSetupEventsImpl {

    public static void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SLIME_BUBBLE.get(), SlimeBubbleParticle.Factory::new);
        //ParticleFactoryRegistry.getInstance().register(FrightsDelightParticleTypes.SLIME_POP.get(), SlimeBubble.Factory::new);
    }
}
