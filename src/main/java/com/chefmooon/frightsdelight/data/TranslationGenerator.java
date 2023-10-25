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
    }
}
