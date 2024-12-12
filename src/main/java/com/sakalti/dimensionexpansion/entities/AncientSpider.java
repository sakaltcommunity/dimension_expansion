package com.sakalti.dimensionexpansion.entities;

import com.sakalti.dimensionexpansion.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.World;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.boss.BossBar;
import net.minecraft.world.boss.BossBarColor;
import net.minecraft.world.boss.BossBarOverlay;

public class AncientSpider extends SpiderEntity {
    private BossBar bossBar;

    public AncientSpider(EntityType<? extends SpiderEntity> entityType, World world) {
        super(entityType, world);
        this.setSize(3.0F, 1.0F); // サイズ変更
        this.bossBar = new BossBar(new TextComponent("Ancient Spider"), BossBarColor.PURPLE, BossBarOverlay.PROGRESS);
        this.bossBar.setSyncToClients(true); // クライアントと同期
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true)); // 攻撃AI
        this.goalSelector.addGoal(2, new SpiderClimbGoal(this)); // 壁を登るAI
        this.goalSelector.addGoal(3, new FollowPlayerGoal(this, 1.0D)); // プレイヤー追跡AI
    }

    public static AttributeSupplier.Builder createAttributes() {
        return SpiderEntity.createAttributes()
            .add(Attributes.MAX_HEALTH, 250.0D) // HP
            .add(Attributes.ARMOR, 4.0D) // 防御力
            .add(Attributes.ATTACK_DAMAGE, 8.0D); // 攻撃力
    }

    @Override
    public void tick() {
        super.tick();
        // ボスバーの更新処理
        if (!this.level.isClientSide) {
            this.bossBar.setProgress(this.getHealth() / this.getMaxHealth());
            this.bossBar.setVisible(true); // ボスバーを表示
        }
    }

    @Override
    protected void dropSpecialItems() {
        super.dropSpecialItems();
        this.entityDropItem(ModItems.ANCIENT_STAFF.getDefaultInstance()); // ドロップアイテム
    }

    // プレイヤーが近くにいる時にボスバーを表示
    @Override
    public void addAdditionalSaveData(net.minecraft.nbt.CompoundTag pTag) {
        super.addAdditionalSaveData(pTag);
        // ここにボスバーの状態を保存する処理を追加することができます
    }

    // ボスバーの状態を表示するメソッド
    public void setBossBarToPlayer(PlayerEntity player) {
        if (!this.level.isClientSide) {
            this.bossBar.addPlayer(player);
        }
    }

    @Override
    public void remove() {
        super.remove();
        this.bossBar.removeAll(); // エンティティが削除される際にボスバーを削除
    }
}
