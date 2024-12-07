package com.sakalti.dimensionexpansion.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;

public class AncientStaff extends Item {
    private static final int COOLDOWN_TICKS = 50; // クールダウン時間（ティック単位）

    public AncientStaff() {
        super(new Item.Properties().maxDamage(540).group(ItemGroup.COMBAT));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        if (!world.isRemote && player != null) {
            // クールダウン中かチェック
            if (!player.getCooldownTracker().hasCooldown(this)) {
                // プレイヤーの視線の先に爆発を発生
                Vector3d look = player.getLookVec();
                Vector3d target = player.getPositionVec().add(look.scale(10));

                world.createExplosion(null, target.x, target.y, target.z, 4.0F, World.Explosion.Mode.BREAK);

                // 耐久値を減らす
                context.getItem().damageItem(1, player, (p) -> p.sendBreakAnimation(context.getHand()));

                // クールダウンを設定
                player.getCooldownTracker().setCooldown(this, COOLDOWN_TICKS);
            }
        }

        return ActionResultType.SUCCESS;
    }
}
