package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.particle.SlimeBubble;
import com.chefmooon.frightsdelight.registry.BlocksRegistry;
import com.chefmooon.frightsdelight.registry.ParticleEffectsRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class FrightsDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlocksRegistry.registerRenderLayer();

        ParticleFactoryRegistry.getInstance().register(ParticleEffectsRegistry.SLIME_BUBBLE.get(), SlimeBubble.Factory::new);
        //ParticleFactoryRegistry.getInstance().register(ParticleEffectsRegistry.SLIME_BUBBLE_POP.get(), SlimeBubble.Factory::new);
    }
}
