package com.sakalti.dimensionexpansion.init;

import com.sakalti.dimensionexpansion.entities.AncientSpider;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DimensionExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static EntityType<AncientSpider> ANCIENT_SPIDER;

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        ANCIENT_SPIDER = EntityType.Builder.create(AncientSpider::new, EntityClassification.MONSTER)
                .size(2.1F, 1.5F)
                .build("ancient_spider");
        ANCIENT_SPIDER.setRegistryName(DimensionExpansion.MODID, "ancient_spider");

        event.getRegistry().register(ANCIENT_SPIDER);
    }
}
