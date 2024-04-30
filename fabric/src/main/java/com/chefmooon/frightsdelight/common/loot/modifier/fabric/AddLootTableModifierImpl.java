package com.chefmooon.frightsdelight.common.loot.modifier.fabric;

import com.chefmooon.frightsdelight.common.Configuration;
import com.chefmooon.frightsdelight.common.mixin.accessor.fabric.LootContextAccessorImpl;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddLootTableModifierImpl extends LootModifier {
    public static final Supplier<Codec<AddLootTableModifierImpl>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst)
                    .and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter((m) -> m.lootTable))
                    .apply(inst, AddLootTableModifierImpl::new)));

    private final ResourceLocation lootTable;
    /**
     * Credit to FD here?
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     */
    protected AddLootTableModifierImpl(LootItemCondition[] conditionsIn, ResourceLocation lootTable) {
        super(conditionsIn);
        this.lootTable = lootTable;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (Configuration.generateSoulBerryLoot()) {
            LootTable extraTable = context.getResolver().getLootTable(this.lootTable);
            LootContext newContext = new LootContext.Builder(((LootContextAccessorImpl)context).getParams()).create(this.lootTable);
            extraTable.getRandomItemsRaw(newContext, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
