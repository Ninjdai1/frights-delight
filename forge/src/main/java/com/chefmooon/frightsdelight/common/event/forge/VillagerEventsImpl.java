package com.chefmooon.frightsdelight.common.event.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.forge.FrightsDelightItemsImpl;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@Mod.EventBusSubscriber(modid = FrightsDelight.MOD_ID)
@ParametersAreNonnullByDefault
public class VillagerEventsImpl {

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (!Configuration.farmersBuyFrDCrops()) return;

        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        VillagerProfession profession = event.getType();
        ResourceLocation professionKey = ForgeRegistries.VILLAGER_PROFESSIONS.getKey(profession);
        if (professionKey == null) return;
        if (professionKey.getPath().equals("butcher")) {
            trades.get(3).add(emeraldForItemsTrade(FrightsDelightItemsImpl.SOUL_BERRY.get(), 10, 12, 30));
        }
        if (professionKey.getPath().equals("butcher")) {
            trades.get(3).add(emeraldForItemsTrade(FrightsDelightItemsImpl.WITHER_BERRY.get(),  5, 12, 40));
        }
    }

    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        if (!Configuration.wanderingTraderSellsFrdDItems()) return;

        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        trades.add(itemForEmeraldTrade(FrightsDelightItemsImpl.SOUL_BERRY.get(), 12, 1));
    }

    public static BasicItemListing emeraldForItemsTrade(ItemLike item, int itemCount, int maxTrades, int xp) {
        return new BasicItemListing(new ItemStack(item, itemCount), new ItemStack(Items.EMERALD), maxTrades, xp, 0.05F);
    }

    public static BasicItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
        return new BasicItemListing(1, new ItemStack(item), maxTrades, xp, 0.05F);
    }
}
