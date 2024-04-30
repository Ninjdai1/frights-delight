package com.chefmooon.frightsdelight.common;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class Configuration {

    @ExpectPlatform
    public static boolean isEnableFrDCrates() {
        return false;
    }

    @ExpectPlatform
    public static boolean farmersBuyFrDCrops() {
        return false;
    }

    @ExpectPlatform
    public static boolean wanderingTraderSellsFrdDItems() {
        return false;
    }

    @ExpectPlatform
    public static boolean generateSoulBerryLoot() {
        return false;
    }

    @ExpectPlatform
    public static boolean generateWildSoulBerry() {
        return false;
    }

    @ExpectPlatform
    public static int chanceWildSoulBerry() {
        return 0;
    }

    @ExpectPlatform
    public static boolean effectOverlays() {
        return false;
    }

    @ExpectPlatform
    public static boolean foodEffectTooltip() {
        return false;
    }

    @ExpectPlatform
    public static void init() {
    }
}
