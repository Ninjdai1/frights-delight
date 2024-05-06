package com.chefmooon.frightsdelight.common.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import eu.midnightdust.lib.config.MidnightConfig;


@SuppressWarnings("all")
public class ConfigurationImpl extends MidnightConfig {

    @Entry(category = "common") public static boolean enableFrDCrates = true;
    @Entry(category = "common") public static boolean farmersBuyFrDCrops = true;
    @Entry(category = "common") public static boolean wanderingTraderSellsFrdDItems = true;

    @Comment(category = "common", centered = true) public static Comment worldGenerationSettings;
    @Entry(category = "common") public static boolean generateSoulBerryLoot = true;
    @Entry(category = "common") public static boolean generateWildSoulBerry = true;
    @Entry(category = "common", min = 0, max = Integer.MAX_VALUE) public static int chanceWildSoulBerry = 50;

    @Entry(category = "client") public static boolean effectOverlays = true;
    @Entry(category = "client") public static boolean foodEffectTooltip = true;
    @Entry(category = "client") public static boolean foodEffectChanceTooltip = true;

    public static boolean isEnableFrDCrates() {
        return enableFrDCrates;
    }

    public static boolean farmersBuyFrDCrops() {
        return farmersBuyFrDCrops;
    }

    public static boolean wanderingTraderSellsFrdDItems() {
        return wanderingTraderSellsFrdDItems;
    }

    public static boolean generateSoulBerryLoot() {
        return generateSoulBerryLoot;
    }

    public static boolean generateWildSoulBerry() {
        return generateWildSoulBerry;
    }

    public static int chanceWildSoulBerry() {
        return chanceWildSoulBerry;
    }

    public static boolean effectOverlays() {
        return effectOverlays;
    }

    public static boolean foodEffectTooltip() {
        return foodEffectTooltip;
    }
    public static boolean foodEffectChanceTooltip() {
        return foodEffectChanceTooltip;
    }

    public static void init() {
        MidnightConfig.init(FrightsDelight.MOD_ID, ConfigurationImpl.class);
    }
}
