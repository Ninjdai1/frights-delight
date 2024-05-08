package com.chefmooon.frightsdelight.client.fabric;

import com.chefmooon.frightsdelight.client.FrightsDelightClient;
import com.chefmooon.frightsdelight.client.event.fabric.ClientSetupEventsImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class FrightsDelightClientImpl implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        FrightsDelightClient.init();

        ClientSetupEventsImpl.registerParticles();

        //CobwebbedEffectOverlayImpl.init(); // TODO: New Feature, implement in next version

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                FrightsDelightBlocksImpl.SOUL_BERRY_BUSH,
                FrightsDelightBlocksImpl.WITHER_BERRY_BUSH,
                FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE,
                FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE,
                FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR,
                FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY,
                FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY);
    }
}
