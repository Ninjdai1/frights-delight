package com.chefmooon.frightsdelight.client.gui.forge;

import com.chefmooon.frightsdelight.client.gui.CobwebbedOverlay;
import com.chefmooon.frightsdelight.client.gui.FrightsDelightGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.GuiOverlayManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CobwebbedOverlayImpl {
    @SubscribeEvent
    public void onRenderGuiOverlayPost(RenderGuiOverlayEvent.Post event) {
        if (event.getOverlay() == GuiOverlayManager.findOverlay(FrightsDelightGUI.FOOD_LEVEL_ELEMENT)) {
            Minecraft mc = Minecraft.getInstance();
            ForgeGui gui = (ForgeGui) mc.gui;
            boolean isMounted = mc.player != null && mc.player.getVehicle() instanceof LivingEntity;
            if (!isMounted && !mc.options.hideGui && gui.shouldDrawSurvivalElements()) {
                CobwebbedOverlay.renderCobwebbedOverlay(mc, event.getGuiGraphics(), gui.rightHeight);
            }
        }
    }

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new CobwebbedOverlayImpl());
    }
}
