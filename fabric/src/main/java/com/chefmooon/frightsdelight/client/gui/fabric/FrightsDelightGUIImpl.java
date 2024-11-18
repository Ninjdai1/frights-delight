package com.chefmooon.frightsdelight.client.gui.fabric;

import com.chefmooon.frightsdelight.client.gui.FrightsDelightGUI;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;

public class FrightsDelightGUIImpl {

    public static int getFoodIconOffset() {
        return 39;
    }

    public static void register() {
        HudRenderCallback.EVENT.register(FrightsDelightGUI.ChillsOverlay.INSTANCE::render);
        HudRenderCallback.EVENT.register(FrightsDelightGUI.CobwebbedOverlay.INSTANCE::render);
        HudRenderCallback.EVENT.register(FrightsDelightGUI.FortifiedMindOverlay.INSTANCE::render);
        HudRenderCallback.EVENT.register(FrightsDelightGUI.HysteriaOverlay.INSTANCE::render);
        HudRenderCallback.EVENT.register(FrightsDelightGUI.InfectedOverlay.INSTANCE::render);
        HudRenderCallback.EVENT.register(FrightsDelightGUI.SlimedOverlay.INSTANCE::render);
        HudRenderCallback.EVENT.register(FrightsDelightGUI.UndeadHungerOverlay.INSTANCE::render);
    }
}
