package com.baconkami.infernalexp.world.surfacebuilders;

import com.baconkami.infernalexp.registries.ModBlocks;
import com.baconkami.infernalexp.registries.ModSurfaceBuilders;
import com.mojang.serialization.Codec;
import com.sun.org.apache.xpath.internal.operations.Mod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class GlowstoneCanyonSurfaceBuilder extends SurfaceBuilder<TernarySurfaceConfig> {

    protected long seed;

    public GlowstoneCanyonSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                         BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, TernarySurfaceConfig config) {
        BlockPos.Mutable block = new BlockPos.Mutable();
        int xPos = x & 15;
        int zPos = z & 15;
        double rawSimplexNoiseSample = this.octavedSimplex(x, z, 1, 0.001F, 2, 0.5f);
        double simplexNoiseSample = rawSimplexNoiseSample * 65;
        double ridgedNoiseSample = 1 - (2 * Math.abs(simplexNoiseSample));

        if (ridgedNoiseSample > -24) {
            if (ridgedNoiseSample > -10) {
                for (int yPos = startHeight; yPos >= startHeight - 80; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
            }
            //Edge 1(Outwardest Edge)
            int noiseAdded = 135;

            if (ridgedNoiseSample > -24 && ridgedNoiseSample < -20) {
                for (int yPos = startHeight; yPos >= noiseAdded; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
            }
            //Edge 2(Middle Edge)
            if (ridgedNoiseSample > -20 && ridgedNoiseSample < -16) {
                for (int yPos = startHeight; yPos >= noiseAdded - 9; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
            }
            //Edge 3(Inner Edge)
            if (ridgedNoiseSample > -16 && ridgedNoiseSample < -10) {
                for (int yPos = startHeight; yPos >= noiseAdded - 18; --yPos) {
                    block.set(xPos, yPos, zPos);
                    if (yPos > seaLevel) {
                        chunkIn.setBlockState(block, Blocks.AIR.getDefaultState(), false);
                    }
                }
                if (noise < 1)
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
                else
                    SurfaceBuilder.DEFAULT.generate
                            (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
            }
        }

        for (int yPos = startHeight - 3; yPos >= seaLevel; --yPos) {
            block.set(xPos, yPos, zPos);
            BlockState currentBlockToReplace = chunkIn.getBlockState(block);
            if (currentBlockToReplace == Blocks.NETHERRACK.getDefaultState()) {

                chunkIn.setBlockState(block, getRandomBlock(random), false);

            }
        }

        if (noise < 1)
            SurfaceBuilder.DEFAULT.generate
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
        else
            SurfaceBuilder.DEFAULT.generate
                    (random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, ModSurfaceBuilders.Config.GLOWSTONE_CANYON);
    }

    private BlockState getRandomBlock(Random rand) {
        int randNumber = rand.nextInt(3);
        switch (randNumber) {
            case 0:
                return ModBlocks.DIMSTONE.getDefaultState();
            case 1:
                return ModBlocks.DULLSTONE.getDefaultState();
            default:
                return Blocks.GLOWSTONE.getDefaultState();
        }
    }

    public double octavedSimplex(int x, int y, float amp, float scale, int octaves, float change) {
        double height = 0;
        for (int i = 0; i < octaves; i++) {
            height += amp;
            scale /= change;
            amp *= change;
        }
        return height;
    }
}
