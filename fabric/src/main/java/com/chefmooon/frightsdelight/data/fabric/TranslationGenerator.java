package com.chefmooon.frightsdelight.data.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightBlocksImpl;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightEntityTypesImpl;
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
        String REI = MOD_ID + ".rei.";
        String WAILA = MOD_ID + ".tooltip.waila";
        String WAILA_CONFIG = "config.waila.plugin_" + MOD_ID;
        String FORMATTED_MOD_ID = "Fright's Delight";

        translationBuilder.add("itemGroup." + MOD_ID, FORMATTED_MOD_ID);

        translationBuilder.add(MOD_ID + ".container.punch_bowl", "Glass Bottle Required.");

        translationBuilder.add(FrightsDelightEntityTypesImpl.BONE_SHARD.get(), "Bone Shard");

        translationBuilder.add(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, "Wither Berry Bush");
        translationBuilder.add(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, "Soul Berry Bush");

        translationBuilder.add(FrightsDelightItemsImpl.BONE_SHARD, "Bone Shard");

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

        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_ROTTEN_FLESH, "Rotten Flesh Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SPIDER_EYE, "Spider Eye Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SLIMEAPPLE, "Slime-Apple Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SLIME, "Slimeball Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.WEB_ON_STICK, "Cobweb Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_GHAST_TEAR, "Ghast Tear Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_SOUL_BERRY, "Soul Berry Kebab");
        translationBuilder.add(FrightsDelightItemsImpl.BONE_KEBAB_WITHER_BERRY, "Wither Berry Kebab");

        translationBuilder.add(FrightsDelightItemsImpl.MONSTER_MASH, "Monster Mash");
        translationBuilder.add(FrightsDelightItemsImpl.PASTA_WITH_SLIMEBALLS, "Slimeball Spaghetti");

        translationBuilder.add(FrightsDelightItemsImpl.SOUP_ROTTEN_FLESH, "Rotten Flesh Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SPIDER_EYE, "Spider Eye Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SLIME, "Slimeball Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SLIMEAPPLE, "Slime-Apple Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_COBWEB, "Cobweb Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_GHAST_TEAR, "Ghast Tear Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_SOUL_BERRY, "Soul Berry Soup");
        translationBuilder.add(FrightsDelightItemsImpl.SOUP_WITHER_BERRY, "Wither Berry Soup");

        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_ROTTEN_FLESH, "Rotten Flesh Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SPIDER_EYE, "Spider Eye Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SLIMEAPPLE, "Slime-Apple Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SLIME, "Slimeball Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_COBWEB, "Cobweb Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_GHAST_TEAR, "Ghast Tear Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_SOUL_BERRY, "Soul Berry Cookie");
        translationBuilder.add(FrightsDelightItemsImpl.COOKIE_WITHER_BERRY, "Wither Berry Cookie");

        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, "Rotten Flesh Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, "Slime-Apple Cider");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, "Spider Eye Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, "Ghast Tear Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, "Soul Berry Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, "Wither Berry Punch");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCH_COBWEB, "Cobweb Punch");

        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_ROTTEN_FLESH, "Rotten Flesh Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SLIMEAPPLE, "Slime-Apple Cider Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SPIDEREYE, "Spider Eye Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_GHASTTEAR, "Ghast Tear Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_SOUL_BERRY, "Soul Berry Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_WITHER_BERRY, "Wither Berry Punch Bowl");
        translationBuilder.add(FrightsDelightItemsImpl.PUNCHBOWL_COBWEB, "Cobweb Punch Bowl");

        translationBuilder.add(EFFECT + ".chills", "Chills");
        translationBuilder.add(EFFECT + ".cobwebbed", "Cobwebbed");
        translationBuilder.add(EFFECT + ".fortified_mind", "Fortified Mind");
        translationBuilder.add(EFFECT + ".hysteria", "Hysteria");
        translationBuilder.add(EFFECT + ".infected", "Infected");
        translationBuilder.add(EFFECT + ".slimed", "Slimed");
        translationBuilder.add(EFFECT + ".undead_hunger", "Undead Hunger");

        translationBuilder.add(EFFECT + ".chills.description", "You feel a spectral presence nearby, you may feel a chill if they pass through you.");
        translationBuilder.add(EFFECT + ".cobwebbed.description", "Slightly decreases walking speed.");
        translationBuilder.add(EFFECT + ".fortified_mind.description", "Removes and grants immunity to Hysteria and Chills.");
        translationBuilder.add(EFFECT + ".hysteria.description", "Your mind may play tricks on you... Monsters can be hear near and far.");
        translationBuilder.add(EFFECT + ".infected.description", "Greatly increases food exhaustion.");
        translationBuilder.add(EFFECT + ".slimed.description", "Slightly decreases walking speed; you may also hear the occasional slimy sound.");
        translationBuilder.add(EFFECT + ".undead_hunger.description", "Removes and grants immunity to Food Poisoning and Infected.");

        translationBuilder.add(MOD_ID + ".effect.chills.start", "You feel a chill in the air ...");
        translationBuilder.add(MOD_ID + ".effect.chills.end", "A warmth returns to the air ...");
        translationBuilder.add(MOD_ID + ".effect.chills.chance", "You feel like you are being watched ...");
        translationBuilder.add(MOD_ID + ".effect.chills.encounter", "You feel a chill run down your spine ...");

        translationBuilder.add(SUBTITLE + ".effect_hysteria.close", "Close Hysteria");
        translationBuilder.add(SUBTITLE + ".effect_hysteria.mid", "Mid Hysteria");
        translationBuilder.add(SUBTITLE + ".effect_hysteria.far", "Distant Hysteria");

        translationBuilder.add(SUBTITLE + ".effect_slimed.walk", "Slimy Feet");

        translationBuilder.add(SUBTITLE + ".block_drinkable_feast.add", "Drink Added");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast.remove", "Drink Removed");

        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_rotten_flesh.bubble", "Fleshy Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_spider_eye.bubble", "Creepy Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_slimeapple.bubble", "Slimy Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_cobweb.bubble", "Sticky Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_ghast_tear.bubble", "Ghastly Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_soul_berry.bubble", "Shimmering Bubble");
        translationBuilder.add(SUBTITLE + ".block_drinkable_feast_wither_berry.bubble", "Withered Bubble");

        translationBuilder.add(SUBTITLE + ".entity.bone_shard.throw", "Bone Shard flies");
        translationBuilder.add(SUBTITLE + ".entity.bone_shard.hit", "Bone Shard shatters");

        translationBuilder.add(ADVANCEMENT + ".root", FORMATTED_MOD_ID);
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
        translationBuilder.add(ADVANCEMENT + ".craft_bone_shard", "Bone Kebab");
        translationBuilder.add(ADVANCEMENT + ".craft_bone_shard.desc", "Cut a Bone with a Knife on a Cutting Board. Can be used to protect, attack, or to make a light snack.");
        translationBuilder.add(ADVANCEMENT + ".hit_skeleton_with_bone_shard", "Bone Shattering");
        translationBuilder.add(ADVANCEMENT + ".hit_skeleton_with_bone_shard.desc", "Throw a Bone Shard at a skeleton!");
        translationBuilder.add(ADVANCEMENT + ".master_chef", "Master of Fright");
        translationBuilder.add(ADVANCEMENT + ".master_chef.desc", "Conquer all food and drink items in " + FORMATTED_MOD_ID);

        translationBuilder.add(CONFIG + "title", FORMATTED_MOD_ID + " Settings");
        translationBuilder.add(CONFIG + "category.common", "Common Settings");
        translationBuilder.add(CONFIG + "category.client", "Client Settings");

        translationBuilder.add(CONFIG + "enableFrDCrates", "Enable FrD Crop Crates?");
        translationBuilder.add(CONFIG + "farmersBuyFrDCrops", "Farmer's Buy FrD Berries");
        translationBuilder.add(CONFIG + "wanderingTraderSellsFrdDItems", "Wandering Trader Sells FrD items");

        translationBuilder.add(CONFIG + "worldGenerationSettings", "World Generation");
        translationBuilder.add(CONFIG + "generateSoulBerryLoot", "Should Soul Berries spawn in Bastion chests?");
        translationBuilder.add(CONFIG + "generateWildSoulBerry", "Should Soul Berry Bushes naturally spawn in the Nether?");

        translationBuilder.add(CONFIG + "fortifiedMindOverlay", "Enable/Disable Fortified Mind Effect Overlay");
        translationBuilder.add(CONFIG + "undeadHungerOverlay", "Enable/Disable Undead Hunger Effect Overlay");
        translationBuilder.add(CONFIG + "slimedOverlay", "Enable/Disable Slime Walk Effect Overlay");
        translationBuilder.add(CONFIG + "cobwebbedOverlay", "Enable/Disable Cobwebbed Effect Overlay");
        translationBuilder.add(CONFIG + "infectedOverlay", "Enable/Disable Infected Effect Overlay");
        translationBuilder.add(CONFIG + "hysteriaOverlay", "Enable/Disable Hysteria Effect Overlay");
        translationBuilder.add(CONFIG + "chillsOverlay", "Enable/Disable Chills Effect Overlay");
        translationBuilder.add(CONFIG + "foodEffectTooltip", "Should meal and drink tooltips display which effects they provide?");
        translationBuilder.add(CONFIG + "foodEffectChanceTooltip", "Should meal and drink tooltips display the chance the effect will be applied?");
        translationBuilder.add(CONFIG + "drinkableFeastParticles", "Should Punch Bowl blocks emit bubble particles?");
        translationBuilder.add(CONFIG + "punchConsumeSound", "Should Punch have a chance to play a sound when consumed?");
        translationBuilder.add(CONFIG + "punchConsumeChance", "The chance a sound will be played while consuming a drink? (4 = 25%)");

        translationBuilder.add(REI + "info.soul_berry", "Found spawning naturally in the Nether or in Bastion chests. Growth requirement: Soul Essence source");
        translationBuilder.add(REI + "info.wither_berry", "Can be transformed from a Soul Berry Bush. Chance to transform on growth when: Soul Berry Bush at Max Growth, Wither Essence source very close, low light level.");

        translationBuilder.add(WAILA + ".bush_growth_condition", "Growth Condition");
        translationBuilder.add(WAILA + ".bush_transform", "Can Transform");
        translationBuilder.add(WAILA + ".punchbowl_servings", "Servings");

        translationBuilder.add(WAILA_CONFIG, FORMATTED_MOD_ID);
        translationBuilder.add(WAILA_CONFIG + ".bush_growth_condition", "Bush Growth Condition");
        translationBuilder.add(WAILA_CONFIG + ".bush_transform_condition", "Bush Transform Condition");
        translationBuilder.add(WAILA_CONFIG + ".punchbowl_servings", "Punch Bowl Servings");
    }
}
