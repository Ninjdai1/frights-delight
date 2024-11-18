package com.chefmooon.frightsdelight.common.item.neoforge;

import com.chefmooon.frightsdelight.common.entity.neoforge.BoneShardEntityImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightSounds;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;

public class BoneShardItemImpl extends Item implements ProjectileItem {
    public BoneShardItemImpl(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack heldStack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), FrightsDelightSounds.ENTITY_BONE_SHARD_THROW.get(), SoundSource.NEUTRAL, 0.5F, 0.4F / (level.random.nextFloat() * 0.4F + 0.8F));
        if (!level.isClientSide) {
            BoneShardEntityImpl projectile = new BoneShardEntityImpl(level, player);
            projectile.setItem(heldStack);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(projectile);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            heldStack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(heldStack, level.isClientSide());
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        BoneShardEntityImpl boneShard = new BoneShardEntityImpl(level, pos.x(), pos.y(), pos.z());
        boneShard.setItem(stack);
        return boneShard;
    }
}