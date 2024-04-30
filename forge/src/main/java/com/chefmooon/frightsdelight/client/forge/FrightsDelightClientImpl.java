package com.chefmooon.frightsdelight.client.forge;

import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class FrightsDelightClientImpl {
    public static void init(final FMLClientSetupEvent event) {
        FrightsDelightClient.init();

        //CobwebbedEffectOverlayImpl.init(); // TODO: New Feature, implement in next version
    }
}
