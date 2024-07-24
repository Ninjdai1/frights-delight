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
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, (trades) -> {
                trades.add(emeraldForItemsTrade(FrightsDelightItemsImpl.SOUL_BERRY,10, 12, 30));
            });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 3, (trades) -> {
                trades.add(emeraldForItemsTrade(FrightsDelightItemsImpl.WITHER_BERRY,5, 12, 40));
            });
        }

        if (Configuration.wanderingTraderSellsFrdDItems()) {
            TradeOfferHelper.registerWanderingTraderOffers(1, (trades) -> {
                trades.add(itemForEmeraldTrade(FrightsDelightItemsImpl.SOUL_BERRY,12, 1));
            });
        }
    }

    public static VillagerTrades.ItemListing emeraldForItemsTrade(ItemLike item, int cost, int maxTrades, int xp) {
        return new VillagerTrades.EmeraldForItems(item, cost, maxTrades, xp);
    }

    public static VillagerTrades.ItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
        return new VillagerTrades.ItemsForEmeralds(new ItemStack(item), 1, 1, maxTrades, xp, 0.05F);
    }
}
