package com.sakalti.dimensionexpansion.world;

import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionType;

import java.util.Random;

public class AncientDimension extends Dimension {
    public AncientDimension(World world, DimensionType type) {
        super(world, type);
    }

    @Override
    public void generateStructures(ServerWorld world, Random random) {
        GridWorldGenerator.generateWorld(world, random, new BlockPos(0, 64, 0)); // グリッドの位置を設定
    }

    @Override
    public void tick() {
        super.tick();
    }
}
