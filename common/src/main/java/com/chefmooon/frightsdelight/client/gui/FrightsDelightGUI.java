package com.chefmooon.frightsdelight.client.gui;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightEffects;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class FrightsDelightGUI {
    public static int foodIconsOffset = getFoodIconOffset();
    public static final ResourceLocation RESOURCE_LOCATION = ResourceLocation.fromNamespaceAndPath(FrightsDelight.MOD_ID, "textures/gui/frd_icons.png");

    @ExpectPlatform
    public static int getFoodIconOffset() {
        throw new AssertionError();
    }

    public static abstract class BaseOverlay implements LayeredDraw.Layer {
        public abstract void render(Minecraft mc, Player player, GuiGraphics guiGraphics, int left, int right, int top, int guiTicks);

        @Override
        public final void render(@NotNull GuiGraphics guiGraphics, @NotNull DeltaTracker deltaTracker) {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null || !shouldRenderOverlay(minecraft, minecraft.player, guiGraphics, minecraft.gui.getGuiTicks()))
                return;

            int top = guiGraphics.guiHeight();
            int left = guiGraphics.guiWidth() / 2 - 91; // left of health bar
            int right = guiGraphics.guiWidth() / 2 + 91; // right of food bar

            render(minecraft, minecraft.player, guiGraphics, left, right, top, minecraft.gui.getGuiTicks());
        }

        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            return !minecraft.options.hideGui && minecraft.gameMode != null && minecraft.gameMode.canHurtPlayer();
        }
    }

    public static class ChillsOverlay extends BaseOverlay {
        public static final ResourceLocation ID = TextUtils.res("chills");
        public static final ChillsOverlay INSTANCE = new ChillsOverlay();
        @Override
        public void render(Minecraft mc, Player player, GuiGraphics graphics, int left, int right, int top, int guiTicks) {
            if (player.getEffect(FrightsDelightEffects.CHILLS) != null) {
                renderNegativeHungerOverlay(HungerType.CHILLS, player, mc, graphics, right, top - foodIconsOffset);
            }
        }

        @Override
        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            if (!Configuration.chillsOverlay()) return false;
            if (FrightsDelightGUI.hasFDOverlay(player)) return false;
            return super.shouldRenderOverlay(minecraft, player, guiGraphics, guiTicks);
        }
    }

    public static class CobwebbedOverlay extends BaseOverlay {
        public static final ResourceLocation ID = TextUtils.res("cobwebbed");
        public static final CobwebbedOverlay INSTANCE = new CobwebbedOverlay();
        @Override
        public void render(Minecraft mc, Player player, GuiGraphics graphics, int left, int right, int top, int guiTicks) {
            if (player.getEffect(FrightsDelightEffects.COBWEBBED) != null) {
                renderNegativeHungerOverlay(HungerType.COBWEBBED, player, mc, graphics, right, top - foodIconsOffset);
            }
        }

        @Override
        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            if (!Configuration.cobwebbedOverlay()) return false;
            if (FrightsDelightGUI.hasPriorityOverlay(player)) return false;
            if (FrightsDelightGUI.hasFDOverlay(player)) return false;
            return super.shouldRenderOverlay(minecraft, player, guiGraphics, guiTicks);
        }
    }

    public static class FortifiedMindOverlay extends BaseOverlay {
        public static final ResourceLocation ID = TextUtils.res("fortified_mind");
        public static final FortifiedMindOverlay INSTANCE = new FortifiedMindOverlay();
        @Override
        public void render(Minecraft mc, Player player, GuiGraphics graphics, int left, int right, int top, int guiTicks) {
            if (player.getEffect(FrightsDelightEffects.FORTIFIED_MIND) != null) {
                renderNegativeHungerOverlay(HungerType.FORTIFIED_MIND, player, mc, graphics, right, top - foodIconsOffset);
            }
        }

        @Override
        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            if (!Configuration.fortifiedMindOverlay()) return false;
            if (FrightsDelightGUI.hasFDOverlay(player)) return false;
            return super.shouldRenderOverlay(minecraft, player, guiGraphics, guiTicks);
        }
    }

    public static class HysteriaOverlay extends BaseOverlay {
        public static final ResourceLocation ID = TextUtils.res("hysteria");
        public static final HysteriaOverlay INSTANCE = new HysteriaOverlay();
        @Override
        public void render(Minecraft mc, Player player, GuiGraphics graphics, int left, int right, int top, int guiTicks) {
            if (player.getEffect(FrightsDelightEffects.HYSTERIA) != null) {
                renderNegativeHungerOverlay(HungerType.HYSTERIA, player, mc, graphics, right, top - foodIconsOffset);
            }
        }

        @Override
        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            if (!Configuration.hysteriaOverlay()) return false;
            if (FrightsDelightGUI.hasFDOverlay(player)) return false;
            return super.shouldRenderOverlay(minecraft, player, guiGraphics, guiTicks);
        }
    }

    public static class InfectedOverlay extends BaseOverlay {
        public static final ResourceLocation ID = TextUtils.res("infected");
        public static final InfectedOverlay INSTANCE = new InfectedOverlay();
        @Override
        public void render(Minecraft mc, Player player, GuiGraphics graphics, int left, int right, int top, int guiTicks) {
            if (player.getEffect(FrightsDelightEffects.INFECTED) != null) {
                renderNegativeHungerOverlay(HungerType.INFECTED, player, mc, graphics, right, top - foodIconsOffset);
            }
        }

        @Override
        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            if (!Configuration.infectedOverlay()) return false;
            if (FrightsDelightGUI.hasPriorityOverlay(player)) return false;
            if (FrightsDelightGUI.hasFDOverlay(player)) return false;
            return super.shouldRenderOverlay(minecraft, player, guiGraphics, guiTicks);
        }
    }

    public static class SlimedOverlay extends BaseOverlay {
        public static final ResourceLocation ID = TextUtils.res("slimed");
        public static final SlimedOverlay INSTANCE = new SlimedOverlay();
        @Override
        public void render(Minecraft mc, Player player, GuiGraphics graphics, int left, int right, int top, int guiTicks) {
            if (player.getEffect(FrightsDelightEffects.SLIMED) != null) {
                renderNegativeHungerOverlay(HungerType.SLIMED, player, mc, graphics, right, top - foodIconsOffset);
            }
        }

        @Override
        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            if (!Configuration.slimedOverlay()) return false;
            if (FrightsDelightGUI.hasPriorityOverlay(player)) return false;
            if (FrightsDelightGUI.hasFDOverlay(player)) return false;
            return super.shouldRenderOverlay(minecraft, player, guiGraphics, guiTicks);
        }
    }

    public static class UndeadHungerOverlay extends BaseOverlay {
        public static final ResourceLocation ID = TextUtils.res("undead_hunger");
        public static final UndeadHungerOverlay INSTANCE = new UndeadHungerOverlay();
        @Override
        public void render(Minecraft mc, Player player, GuiGraphics graphics, int left, int right, int top, int guiTicks) {
            if (player.getEffect(FrightsDelightEffects.UNDEAD_HUNGER) != null) {
                renderNegativeHungerOverlay(HungerType.UNDEAD_HUNGER, player, mc, graphics, right, top - foodIconsOffset);
            }
        }

        @Override
        public boolean shouldRenderOverlay(Minecraft minecraft, Player player, GuiGraphics guiGraphics, int guiTicks) {
            if (!Configuration.undeadHungerOverlay()) return false;
            if (FrightsDelightGUI.hasFDOverlay(player)) return false;
            return super.shouldRenderOverlay(minecraft, player, guiGraphics, guiTicks);
        }
    }

    public static void renderNegativeHungerOverlay(HungerType hungerType, Player player, Minecraft mc, GuiGraphics graphics, int right, int top) {
        FoodData stats = player.getFoodData();
        float saturation = stats.getSaturationLevel();
        int foodLevel = stats.getFoodLevel();
        int ticks = mc.gui.getGuiTicks();
        Random rand = new Random();
        rand.setSeed(ticks * 312871);

        RenderSystem.enableBlend();

        for (int j = 0; j < 10; ++j) {
            int x = right - j * 8 - 9;
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
        return player.getEffect(FrightsDelightEffects.FORTIFIED_MIND) != null || player.getEffect(FrightsDelightEffects.UNDEAD_HUNGER) != null;
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
