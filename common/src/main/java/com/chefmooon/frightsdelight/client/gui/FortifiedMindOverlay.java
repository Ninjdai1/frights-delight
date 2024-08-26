package com.chefmooon.frightsdelight.client.gui;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

public class FortifiedMindOverlay {
    public static void renderFortifiedMindOverlay(Minecraft mc, GuiGraphics graphics, int foodIconsOffset) {
        if (!Configuration.fortifiedMindOverlay()) return;

        Player player = mc.player;

        if (player == null) return;

        int top = mc.getWindow().getGuiScaledHeight() - foodIconsOffset + 10;
        int left = mc.getWindow().getGuiScaledWidth() / 2 + 91;

        if (FrightsDelightGUI.hasFDOverlay(player)) return;

        if (player.getEffect(FrightsDelightEffects.FORTIFIED_MIND.get()) != null) {
            FrightsDelightGUI.renderNegativeHungerOverlay(FrightsDelightGUI.HungerType.FORTIFIED_MIND, player, mc, graphics, left, top);
        }
    }

    @ExpectPlatform
    public static void init() {
        throw new AssertionError();
    }
}
