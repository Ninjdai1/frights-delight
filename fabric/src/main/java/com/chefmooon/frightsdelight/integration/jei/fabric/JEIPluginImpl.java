package com.chefmooon.frightsdelight.integration.jei.fabric;

import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import com.chefmooon.frightsdelight.integration.jei.JEIPlugin;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
@MethodsReturnNonnullByDefault
@SuppressWarnings("unused")
public class JEIPluginImpl implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return JEIPlugin.ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addIngredientInfo(new ItemStack(FrightsDelightItemsImpl.SOUL_BERRY), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.soul_berry"));
        registration.addIngredientInfo(new ItemStack(FrightsDelightItemsImpl.WITHER_BERRY), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.wither_berry"));
    }
}
