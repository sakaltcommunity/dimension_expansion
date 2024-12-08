package com.sakalti.dimensionexpansion.entities;

import com.sakalti.dimensionexpansion.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.entity.ai.attributes.Attributes;

public class AncientSpider extends SpiderEntity {
    public AncientSpider(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
        this.setSize(3.0F, 1.0F); // サイズ変更
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true)); // 攻撃AI
        this.goalSelector.addGoal(2, new SpiderClimbGoal(this)); // 壁を登るAI
        this.goalSelector.addGoal(3, new FollowPlayerGoal(this, 1.0D)); // プレイヤー追跡AI
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(250.0D); // HP
        this.getAttribute(Attributes.ARMOR).setBaseValue(4.0D); // 防御力
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(8.0D); // 攻撃力
    }

    @Override
    protected void dropSpecialItems() {
        super.dropSpecialItems();
        this.entityDropItem(ModItems.ANCIENT_STAFF.getDefaultInstance()); // ドロップアイテム
    }
}
