package com.sakalti.dimensionexpansion.init;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSpawnEggs {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "dimensionexpansion");

    // AncientSpiderのスポーンエッグ
    public static final RegistryObject<SpawnEggItem> ANCIENT_SPIDER_SPAWN_EGG = ITEMS.register("ancient_spider_spawn_egg",
            () -> new SpawnEggItem(ModEntities.ANCIENT_SPIDER.get(), 0x4B0082, 0xFFD700, // 色指定: 紫と金
                    new Item.Properties()));

    // タブ登録用メソッド
    public static void addToCreativeTab(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(ANCIENT_SPIDER_SPAWN_EGG);
        }
    }

    // 登録メソッド
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
