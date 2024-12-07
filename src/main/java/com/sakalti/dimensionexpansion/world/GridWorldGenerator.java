package com.sakalti.dimensionexpansion.world;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class GridWorldGenerator {
    public static void generateWorld(ServerWorld world, Random random, BlockPos startPos) {
        int size = 32;
        for (int x = -size / 2; x < size / 2; x++) {
            for (int z = -size / 2; z < size / 2; z++) {
                BlockPos pos = startPos.add(x * 16, 0, z * 16); // グリッドの各位置に16ブロック単位のチャンクを生成
                world.setBlockState(pos, net.minecraft.block.Blocks.STONE.getDefaultState(), 3); // グリッドのブロックを設定
            }
        }
    }
}
