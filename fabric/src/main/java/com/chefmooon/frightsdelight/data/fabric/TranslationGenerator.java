package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class TranslationGenerator extends FabricLanguageProvider {
    public TranslationGenerator(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        String MOD_ID = FrightsDelight.MOD_ID;
        String SUBTITLE = MOD_ID + ".subtitles";
        String EFFECT = "effect." + MOD_ID;
        String ADVANCEMENT = MOD_ID + ".advancement";
        String CONFIG = MOD_ID + ".midnightconfig.";

        translationBuilder.add("itemGroup." + MOD_ID, "Fright's Delight");

        translationBuilder.add(MOD_ID + ".container.punch_bowl", "Glass Bottle Required.");

        translationBuilder.add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, "Wither Berry Bush");
        translationBuilder.add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, "Soul Berry Bush");

        translationBuilder.add(FrightsDelightItemsImpl.WITHER_BERRY, "Wither Berries");
        translationBuilder.add(FrightsDelightItemsImpl.SOUL_BERRY, "Soul Berries");

        translationBuilder.add(FrightsDelightItemsImpl.FLESH_CRATE, "Flesh Crate");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_CRATE, "Bone Crate");
        translationBuilder.add(FrightsDelightItemsImpl.PHANTOM_CRATE, "Phantom Membrane Crate");
        translationBuilder.add(FrightsDelightItemsImpl.WEB_CRATE, "Cobweb Crate");
        translationBuilder.add(FrightsDelightItemsImpl.SPIDER_EYE_CRATE, "Spider Eye Crate");
        translationBuilder.add(FrightsDelightItemsImpl.FERMENTED_SPIDER_EYE_CRATE, "Fermented Spider Eye Crate");
        translationBuilder.add(FrightsDelightItemsImpl.POISONOUS_POTATO_CRATE, "Poisonous Potato Crate");
        translationBuilder.add(FrightsDelightItemsImpl.ROTTEN_TOMATO_CRATE, "Rotten Tomato Crate");

        translationBuilder.add(FrightsDelightItemsImpl.APPLE_SLIME, "Slime-Apple");
        translationBuilder.add(FrightsDelightItemsImpl.UNDEAD_KEBAB, "Undead Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.WEB_ON_STICK, "Cobweb on a Stick");

        translationBuilder.add(FrightsDelightItemsImpl.MONSTER_MASH, "Monster Mash");
        translationBuilder.add(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS, "Slimeball Spaghetti");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH, "Rotten Flesh Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE, "Spider Eye Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SLIME, "Slimeball Soup");

        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY, "Soul Berry Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH, "Rotten Flesh Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE, "Spider Eye Cookie");

        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, "Slime-Apple Cider");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, "Spider-Eye Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, "Ghast Tear Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, "Soul Berry Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, "Wither Berry Punch");

        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE, "Slime-Apple Cider Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE, "Spider-Eye Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR, "Ghast Tear Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY, "Soul Berry Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY, "Wither Berry Punch Bowl");

        translationBuilder.add(EFFECT + ".chills", "Chills");
        translationBuilder.add(EFFECT + ".cobwebbed", "Cobwebbed");
        translationBuilder.add(EFFECT + ".fortified_mind", "Fortified Mind");
        translationBuilder.add(EFFECT + ".hysteria", "Hysteria");
        translationBuilder.add(EFFECT + ".infected", "Infected");
        translationBuilder.add(EFFECT + ".slimed", "Slimed");
        translationBuilder.add(EFFECT + ".undead_hunger", "Undead Hunger");

        translationBuilder.add(MOD_ID + ".effect.chills.start", "You feel a chill in the air ...");
        translationBuilder.add(MOD_ID + ".effect.chills.end", "A warmth returns to the air ...");
        translationBuilder.add(MOD_ID + ".effect.chills.chance", "You feel like you are being watched ...");
        translationBuilder.add(MOD_ID + ".effect.chills.encounter", "You feel a chill run down your spine ...");

        translationBuilder.add(SUBTITLE + ".effect_hysteria.close", "Close Hysteria");
        translationBuilder.add(SUBTITLE + ".effect_hysteria.mid", "Mid Hysteria");
        translationBuilder.add(SUBTITLE + ".effect_hysteria.far", "Distant Hysteria");

        translationBuilder.add(SUBTITLE + ".block_drinkable_feast.add", "Drink Added");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast.remove", "Drink Removed");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast.bubble", "Slimy Bubble");

        translationBuilder.add(ADVANCEMENT + ".root", "Fright's Delight");
        translationBuilder.add(ADVANCEMENT + ".root.desc", "Welcome to a world of unusual delights. Consume with caution.");
        translationBuilder.add(ADVANCEMENT + ".get_soul_berry", "Soul Berry Bush");
        translationBuilder.add(ADVANCEMENT + ".get_soul_berry.desc", "These can be found in Bastion chests in the Nether and require a Soul Flame source nearby to grow. Berries will shimmer if growing");
        translationBuilder.add(ADVANCEMENT + ".get_wither_berry", "Wither Berry Bush");
        translationBuilder.add(ADVANCEMENT + ".get_wither_berry.desc", "Soul Berry Bush can be turned into this in the dark with a Wither Essence source very close. Berries will smoke if growing");
        translationBuilder.add(ADVANCEMENT + ".get_monster_drop", "Unusual Effects");
        translationBuilder.add(ADVANCEMENT + ".get_monster_drop.desc", "Food made with monster drops may not look good ... but some say it tastes like chicken. Beware of adverse effects.");
        translationBuilder.add(ADVANCEMENT + ".craft_cookie", "Cooked Monster");
        translationBuilder.add(ADVANCEMENT + ".craft_cookie.desc", "Cooking the food in different ways seems to make the effect less common");
        translationBuilder.add(ADVANCEMENT + ".craft_best", "Almost Edible");
        translationBuilder.add(ADVANCEMENT + ".craft_best.desc", "Food in plates, bowls, and drinks seem to be the \"safest\" to consume");
        translationBuilder.add(ADVANCEMENT + ".craft_punch_bowl", "Something's in my Punch");
        translationBuilder.add(ADVANCEMENT + ".craft_punch_bowl.desc", "Drinks can be combined and placed. Grab a bottle and have a sip!");
        translationBuilder.add(ADVANCEMENT + ".master_chef", "Master of Fright");
        translationBuilder.add(ADVANCEMENT + ".master_chef.desc", "Conquer all food and drink items in Fright's Delight");

        translationBuilder.add(CONFIG + "title", "Frights Delight Settings");
        translationBuilder.add(CONFIG + "category.common", "Common Settings");
        translationBuilder.add(CONFIG + "category.client", "Client Settings");

        translationBuilder.add(CONFIG + "enableFrDCrates", "Enable FrD Crop Crates?");
        translationBuilder.add(CONFIG + "farmersBuyFrDCrops", "Farmer's Buy FrD Berries");
        translationBuilder.add(CONFIG + "wanderingTraderSellsFrdDItems", "Wandering Trader Sells FrD items");

        translationBuilder.add(CONFIG + "worldGenerationSettings", "World Generation");
        translationBuilder.add(CONFIG + "generateSoulBerryLoot", "Should Soul Berries spawn in Bastion chests?");
        translationBuilder.add(CONFIG + "generateWildSoulBerry", "Should Soul Berry Bushes naturally spawn in the Nether?");
        translationBuilder.add(CONFIG + "chanceWildSoulBerry", "Chance of generating Soul Berry Bush clusters. Smaller value = more frequent.");

        translationBuilder.add(CONFIG + "effectOverlays", "Enable/Disable Effect Overlays");
        translationBuilder.add(CONFIG + "foodEffectTooltip", "Should meal and drink tooltips display which effects they provide?");
    }
}
