package com.chefmooon.frightsdelight.integration.rei.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.network.chat.Component;

public class ClientREIPlugin implements REIClientPlugin {

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(FrightsDelightItemsImpl.SOUL_BERRY), Component.translatable("item.frightsdelight.soul_berry")).lines(TextUtils.getTranslatable("rei.info.soul_berry")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(FrightsDelightItemsImpl.WITHER_BERRY), Component.translatable("item.frightsdelight.wither_berry")).lines(TextUtils.getTranslatable("rei.info.wither_berry")));
    }
}
