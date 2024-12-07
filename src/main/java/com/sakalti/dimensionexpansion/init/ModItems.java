package com.sakalti.dimensionexpansion.init;

import com.sakalti.dimensionexpansion.items.AncientStaff;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DimensionExpansion.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static Item ANCIENT_STAFF;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        ANCIENT_STAFF = new AncientStaff();
        ANCIENT_STAFF.setRegistryName(DimensionExpansion.MODID, "ancient_staff");
        event.getRegistry().register(ANCIENT_STAFF);
    }
}
