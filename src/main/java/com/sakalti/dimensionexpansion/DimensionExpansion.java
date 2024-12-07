package com.sakalti.dimensionexpansion;

import com.sakalti.dimensionexpansion.init.ModEntities;
import com.sakalti.dimensionexpansion.init.ModItems;
import com.sakalti.dimensionexpansion.init.ModDimensions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DimensionExpansion.MODID)
public class DimensionExpansion {
    public static final String MODID = "dimensionexpansion";

    public DimensionExpansion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // アイテムとエンティティの登録
        ModItems.registerItems(modEventBus);
        ModEntities.registerEntities(modEventBus);
        ModDimensions.registerDimensions(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // サーバーサイドの初期化
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // クライアントサイドの初期化
    }
}
