package com.chefmooon.frightsdelight.common.event.fabric;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.registry.fabric.FrightsDelightItemsImpl;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class VillagerEventsImpl {

    public static void init() {
        ServerLifecycleEvents.SERVER_STARTING.register(client -> addTrades());
    }

    public static void addTrades() {
        if (Configuration.farmersBuyFrDCrops()) {
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, (trades) -> {
                trades.add(itemForEmeraldTrade(FrightsDelightItemsImpl.SOUL_BERRY.get(), 2, 10));
            });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, (trades) -> {
                trades.add(itemForEmeraldTrade(FrightsDelightItemsImpl.WITHER_BERRY.get(), 2, 10));
            });
        }

        if (Configuration.wanderingTraderSellsFrdDItems()) {
            TradeOfferHelper.registerWanderingTraderOffers(3, (trades) -> {
                trades.add(emeraldForItemsTrade(FrightsDelightItemsImpl.SOUL_BERRY.get(), 4, 2, 10));
            });
        }

    }

    public static VillagerTrades.ItemListing emeraldForItemsTrade(ItemLike item, int count, int maxTrades, int xp) {
        return new VillagerTrades.EmeraldForItems(item, count, maxTrades, xp);
    }

    public static VillagerTrades.ItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
        return new VillagerTrades.ItemsForEmeralds(new ItemStack(item), 1, 1, maxTrades, xp, 0.05F);
    }
}
