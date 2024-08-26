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
    public static boolean fortifiedMindOverlay() {
        return false;
    }

    @ExpectPlatform
    public static boolean undeadHungerOverlay() {
        return false;
    }

    @ExpectPlatform
    public static boolean slimedOverlay() {
        return false;
    }

    @ExpectPlatform
    public static boolean cobwebbedOverlay() {
        return false;
    }

    @ExpectPlatform
    public static boolean infectedOverlay() {
        return false;
    }

    @ExpectPlatform
    public static boolean hysteriaOverlay() {
        return false;
    }

    @ExpectPlatform
    public static boolean chillsOverlay() {
        return false;
    }

    @ExpectPlatform
    public static boolean foodEffectTooltip() {
        return false;
    }


    @ExpectPlatform
    public static boolean foodEffectChanceTooltip() {
        return false;
    }

    @ExpectPlatform
    public static boolean foodEffectChanceTooltip() {
        return false;
    }

    @ExpectPlatform
    public static void init() {
    }
}
