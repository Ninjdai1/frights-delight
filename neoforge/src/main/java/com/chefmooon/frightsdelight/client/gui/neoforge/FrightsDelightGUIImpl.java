package com.chefmooon.frightsdelight.client.gui.neoforge;

import com.chefmooon.frightsdelight.client.gui.FrightsDelightGUI;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.client.Minecraft;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

public class FrightsDelightGUIImpl {
    public static int foodIconsOffset;

    public static int getFoodIconOffset() {
        return foodIconsOffset;
    }

    public static void register(RegisterGuiLayersEvent event) {
        event.registerBelow(
                VanillaGuiLayers.FOOD_LEVEL,
                TextUtils.res("food_offset"),
                (guiGraphics, deltaTracker) -> foodIconsOffset = Minecraft.getInstance().gui.rightHeight
        );
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, FrightsDelightGUI.ChillsOverlay.ID, new FrightsDelightGUI.ChillsOverlay());
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, FrightsDelightGUI.CobwebbedOverlay.ID, new FrightsDelightGUI.CobwebbedOverlay());
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, FrightsDelightGUI.FortifiedMindOverlay.ID, new FrightsDelightGUI.FortifiedMindOverlay());
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, FrightsDelightGUI.HysteriaOverlay.ID, new FrightsDelightGUI.HysteriaOverlay());
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, FrightsDelightGUI.InfectedOverlay.ID, new FrightsDelightGUI.InfectedOverlay());
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, FrightsDelightGUI.SlimedOverlay.ID, new FrightsDelightGUI.SlimedOverlay());
        event.registerAbove(VanillaGuiLayers.FOOD_LEVEL, FrightsDelightGUI.UndeadHungerOverlay.ID, new FrightsDelightGUI.UndeadHungerOverlay());
    }
}
