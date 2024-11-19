package com.chefmooon.frightsdelight.client.gui.fabric;

import com.chefmooon.frightsdelight.client.gui.ChillsOverlay;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;

public class ChillsOverlayImpl {
    private static void onRenderGuiOverlayPost(GuiGraphics graphics, float partialTicks) {
        Minecraft mc = Minecraft.getInstance();
        //var gui = mc.gui;
        if (!mc.options.hideGui && mc.gameMode != null && mc.gameMode.canHurtPlayer()) {
            ChillsOverlay.renderChillsOverlay(mc, graphics, 49);
        }
    }

    public static void init() {
        HudRenderCallback.EVENT.register(ChillsOverlayImpl::onRenderGuiOverlayPost);
    }
}