package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.registry.BlocksRegistry;
import net.fabricmc.api.ClientModInitializer;

public class FrightsDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlocksRegistry.registerRenderLayer();
    }
}
