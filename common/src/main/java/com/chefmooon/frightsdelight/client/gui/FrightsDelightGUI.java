package com.chefmooon.frightsdelight.client.gui;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

import java.util.Random;

public class FrightsDelightGUI {
    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(FrightsDelight.MOD_ID, "textures/gui/frd_icons.png");
    public static final ResourceLocation FOOD_LEVEL_ELEMENT = new ResourceLocation("minecraft", "food_level");

    public static void renderNegativeHungerOverlay(HungerType hungerType, Player player, Minecraft mc, GuiGraphics graphics, int left, int top) {
        if (player == null) return;

        FoodData stats = player.getFoodData();
        float saturation = stats.getSaturationLevel();
        int foodLevel = stats.getFoodLevel();
        int ticks = mc.gui.getGuiTicks();
        Random rand = new Random();
        rand.setSeed(ticks * 312871);

        RenderSystem.enableBlend();

        for (int j = 0; j < 10; ++j) {
            int x = left - j * 8 - 9;
            int y = top;

            if (saturation <= 0.0F && ticks % (foodLevel * 3 + 1) == 0) {
                y = top + (rand.nextInt(3) - 1);
            }

            graphics.blit(RESOURCE_LOCATION, x, y, hungerType.getOutlineUOffset(), hungerType.getOutlineVOffset(), 9, 9);

            if (hungerType.isHasFill()) {
                float effectiveHungerOfBar = (stats.getFoodLevel()) / 2.0F - j;

                if (effectiveHungerOfBar >= 1) {
                    graphics.blit(RESOURCE_LOCATION, x, y, hungerType.getOutlineUOffset() + hungerType.getUFillOffset(false), 0, 9, 9);
                } else if (effectiveHungerOfBar >= .5) {
                    graphics.blit(RESOURCE_LOCATION, x, y, hungerType.getOutlineUOffset() + hungerType.getUFillOffset(true), 0, 9, 9);
                }
            }
        }

        RenderSystem.disableBlend();
    }

    public static boolean hasPriorityOverlay(Player player) {
        return player.getEffect(FrightsDelightEffects.FORTIFIED_MIND.get()) != null || player.getEffect(FrightsDelightEffects.UNDEAD_HUNGER.get()) != null;
    }

    public static boolean hasFDOverlay(Player player) {
        return player.getEffect(FoodValues.getNourishment()) != null;
    }

    public enum HungerType {
        NORMAL(0, 0, 0, false),
        FORTIFIED_MIND(1, 9, 10, false),
        UNDEAD_HUNGER(2, 28, 0, true),
        HYSTERIA(3, 27, 10, false),
        CHILLS(4, 36, 10, false),
        SLIMED(5, 18, 10, false),
        COBWEBBED(6, 0, 10, false),
        INFECTED(7, 0, 0, true)
        ;
        private final int index;
        private final int outlineUOffset;
        private final int outlineVOffset;
        private final boolean hasFill;

        HungerType(int index, int outlineUOffset, int outlineVOffset, boolean hasFill) {
            this.index = index;
            this.outlineUOffset = outlineUOffset;
            this.outlineVOffset = outlineVOffset;
            this.hasFill = hasFill;
        }

        public int getIndex() {
            return index;
        }

        public int getOutlineUOffset() {
            return outlineUOffset;
        }

        public int getOutlineVOffset() {
            return outlineVOffset;
        }

        public boolean isHasFill() {
            return hasFill;
        }

        public int getUFillOffset(Boolean half) {
            return half ? 9 : 18;
        }
    }
}
