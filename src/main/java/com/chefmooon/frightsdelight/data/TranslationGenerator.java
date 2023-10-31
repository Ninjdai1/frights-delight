package com.chefmooon.frightsdelight.data;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.registry.ItemsRegistry;
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

        translationBuilder.add(FrightsDelight.ITEM_GROUP, "Fright's Delight");

        translationBuilder.add(MOD_ID + ".container.punch_bowl", "Glass Bottle Required.");
        
        translationBuilder.add(ItemsRegistry.SOUL_BERRY.get(), "Soul Berries");
        translationBuilder.add(ItemsRegistry.WITHER_BERRY.get(), "Wither Berries");

        translationBuilder.add(ItemsRegistry.FLESH_CRATE.get(), "Flesh Crate");
        translationBuilder.add(ItemsRegistry.BONE_CRATE.get(), "Bone Crate");
        translationBuilder.add(ItemsRegistry.PHANTOM_CRATE.get(), "Phantom Membrane Crate");
        translationBuilder.add(ItemsRegistry.WEB_CRATE.get(), "Cobweb Crate");
        translationBuilder.add(ItemsRegistry.SPIDER_EYE_CRATE.get(), "Spider Eye Crate");
        translationBuilder.add(ItemsRegistry.FERMENTED_SPIDER_EYE_CRATE.get(), "Fermented Spider Eye Crate");
        translationBuilder.add(ItemsRegistry.POISONOUS_POTATO_CRATE.get(), "Poisonous Potato Crate");
        translationBuilder.add(ItemsRegistry.ROTTEN_TOMATO_CRATE.get(), "Rotten Tomato Crate");

        translationBuilder.add(ItemsRegistry.APPLE_SLIME.get(), "Slime-Apple");
        translationBuilder.add(ItemsRegistry.UNDEAD_KEBAB.get(), "Undead Kebab");
        translationBuilder.add(ItemsRegistry.WEB_ON_STICK.get(), "Cobweb on a Stick");

        translationBuilder.add(ItemsRegistry.MONSTER_MASH.get(), "Monster Mash");
        translationBuilder.add(ItemsRegistry.PASTA_WITH_SLIMEBALLS.get(), "Slimeball Spaghetti");
        translationBuilder.add(ItemsRegistry.SOUP_ROTTEN_FLESH.get(), "Rotten Flesh Soup");
        translationBuilder.add(ItemsRegistry.SOUP_SPIDER_EYE.get(), "Spider Eye Soup");
        translationBuilder.add(ItemsRegistry.SOUP_SLIME.get(), "Slimeball Soup");

        translationBuilder.add(ItemsRegistry.COOKIE_SOUL_BERRY.get(), "Soul Berry Cookie");
        translationBuilder.add(ItemsRegistry.COOKIE_FLESH.get(), "Rotten Flesh Cookie");
        translationBuilder.add(ItemsRegistry.COOKIE_SPIDEREYE.get(), "Spider Eye Cookie");

        translationBuilder.add(ItemsRegistry.PUNCH_SLIMEAPPLE.get(), "Slime-Apple Cide");
        translationBuilder.add(ItemsRegistry.PUNCH_SPIDEREYE.get(), "Spider-Eye Punch");
        translationBuilder.add(ItemsRegistry.PUNCH_GHASTTEAR.get(), "Ghast Tear Punch");
        translationBuilder.add(ItemsRegistry.PUNCH_SOUL_BERRY.get(), "Soul Berry Punch");
        translationBuilder.add(ItemsRegistry.PUNCH_WITHER_BERRY.get(), "Wither Berry Punch");

        translationBuilder.add(ItemsRegistry.PUNCHBOWL_SLIMEAPPLE.get(), "Slime-Apple Cider Bowl");
        translationBuilder.add(ItemsRegistry.PUNCHBOWL_SPIDEREYE.get(), "Spider-Eye Punch Bowl");
        translationBuilder.add(ItemsRegistry.PUNCHBOWL_GHASTTEAR.get(), "Ghast Tear Punch Bowl");
        translationBuilder.add(ItemsRegistry.PUNCHBOWL_SOUL_BERRY.get(), "Soul Berry Punch Bowl");
        translationBuilder.add(ItemsRegistry.PUNCHBOWL_WITHER_BERRY.get(), "Wither Berry Punch Bowl");

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
    }
}
