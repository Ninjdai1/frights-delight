package com.chefmooon.frightsdelight.client.gui;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class CobwebbedOverlay {
    public static void renderCobwebbedOverlay(Minecraft mc, GuiGraphics graphics, int foodIconsOffset) {
        if (!Configuration.cobwebbedOverlay()) return;

        Player player = mc.player;

        if (player == null) return;

        int top = mc.getWindow().getGuiScaledHeight() - foodIconsOffset + 10;
        int left = mc.getWindow().getGuiScaledWidth() / 2 + 91;

        if (FrightsDelightGUI.hasPriorityOverlay(player)) return;
        if (FrightsDelightGUI.hasFDOverlay(player)) return;

        if (player.getEffect(FrightsDelightEffects.COBWEBBED.get()) != null) {
            FrightsDelightGUI.renderNegativeHungerOverlay(FrightsDelightGUI.HungerType.COBWEBBED, player, mc, graphics, left, top);
        }
    }

    @ExpectPlatform
    public static void init() {
        throw new AssertionError();
    }
}
