package com.sakalti.dimensionexpansion.init;

import com.sakalti.dimensionexpansion.DimensionExpansion;
import com.sakalti.dimensionexpansion.world.GridWorldGenerator;
import com.sakalti.dimensionexpansion.world.AncientDimension;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModDimensions {
    public static final DeferredRegister<DimensionType> DIMENSIONS = DeferredRegister.create(ForgeRegistries.DIMENSIONS, DimensionExpansion.MODID);
    public static final RegistryObject<DimensionType> ANCIENT_DIMENSION = DIMENSIONS.register("ancient", () -> DimensionType.createOverworld());

    @SubscribeEvent
    public static void registerDimensions(IEventBus eventBus) {
        DIMENSIONS.register(eventBus);
    }

    public static void createAncientDimension(ServerWorld world, ResourceLocation dimensionID) {
        Dimension dimension = new AncientDimension(world.getServer(), world.getDimension().getType(), dimensionID);
        GridWorldGenerator.generateWorld(world, world.getRandom(), new BlockPos(0, 64, 0));
    }
}
