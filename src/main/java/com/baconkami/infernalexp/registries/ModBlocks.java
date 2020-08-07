package com.baconkami.infernalexp.registries;

import com.baconkami.infernalexp.InfernalExpansion;
import com.baconkami.infernalexp.blocks.LayerBlock;
import com.baconkami.infernalexp.blocks.ModStairsBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    public static Block DIMSTONE;
    public static Block DULLSTONE;
    public static Block SMOOTH_GLOWSTONE;
    public static Block SMOOTH_DIMSTONE;
    public static Block SMOOTH_DULLSTONE;
    public static Block GLOWSTONE_BRICK;
    public static Block DIMSTONE_BRICK;
    public static Block DULLSTONE_BRICK;
    public static Block CHISELED_GLOWSTONE_BRICK;
    public static Block CHISELED_DIMSTONE_BRICK;
    public static Block CHISELED_DULLSTONE_BRICK;
    public static Block SMOOTH_GLOWSTONE_SLAB;
    public static Block SMOOTH_GLOWSTONE_STAIRS;
    public static Block SMOOTH_DIMSTONE_SLAB;
    public static Block SMOOTH_DIMSTONE_STAIRS;
    public static Block SMOOTH_DULLSTONE_SLAB;
    public static Block SMOOTH_DULLSTONE_STAIRS;
    public static Block GLOWSTONE_BRICK_SLAB;
    public static Block GLOWSTONE_BRICK_STAIRS;
    public static Block DIMSTONE_BRICK_SLAB;
    public static Block DIMSTONE_BRICK_STAIRS;
    public static Block DULLSTONE_BRICK_SLAB;
    public static Block DULLSTONE_BRICK_STAIRS;

    public static Block GLOWDUST;
    public static Block GLOWDUST_SAND;
    public static Block GLOWDUST_SANDSTONE;
    public static Block CUT_GLOWDUST_SANDSTONE;
    public static Block CHISELED_GLOWDUST_SANDSTONE;
    public static Block GLOWDUST_SANDSTONE_SLAB;
    public static Block GLOWDUST_SANDSTONE_STAIRS;

    public static Block GLIMMERING_BLACKSTONE;

    public static void registerAll() {
        DIMSTONE = register("dimstone", new Block(getProperties(Blocks.GLOWSTONE).lightLevel(10)));
        DULLSTONE = register("dullstone", new Block(getProperties(Blocks.GLOWSTONE).lightLevel(0)));
        SMOOTH_GLOWSTONE = register("smooth_glowstone", new Block(getProperties(Blocks.STONE).lightLevel(15)));
        SMOOTH_DIMSTONE = register("smooth_dimstone", new Block(getProperties(Blocks.STONE).lightLevel(10)));
        SMOOTH_DULLSTONE = register("smooth_dullstone", new Block(getProperties(Blocks.STONE).lightLevel(0)));
        GLOWSTONE_BRICK = register("glowstone_brick", new Block(getProperties(SMOOTH_GLOWSTONE)));
        DIMSTONE_BRICK = register("dimstone_brick", new Block(getProperties(SMOOTH_DIMSTONE)));
        DULLSTONE_BRICK = register("dullstone_brick", new Block(getProperties(SMOOTH_DULLSTONE)));
        CHISELED_GLOWSTONE_BRICK = register("chiseled_glowstone_brick", new Block(getProperties(SMOOTH_GLOWSTONE)));
        CHISELED_DIMSTONE_BRICK = register("chiseled_dimstone_brick", new Block(getProperties(SMOOTH_DIMSTONE)));
        CHISELED_DULLSTONE_BRICK = register("chiseled_dullstone_brick", new Block(getProperties(SMOOTH_DULLSTONE)));
        SMOOTH_GLOWSTONE_SLAB = register("smooth_glowstone_slab", new SlabBlock(getProperties(SMOOTH_GLOWSTONE)));
        SMOOTH_GLOWSTONE_STAIRS = register("smooth_glowstone_stairs", new ModStairsBlock(SMOOTH_GLOWSTONE));
        SMOOTH_DIMSTONE_SLAB = register("smooth_dimstone_slab", new SlabBlock(getProperties(SMOOTH_DIMSTONE)));
        SMOOTH_DIMSTONE_STAIRS = register("smooth_dimstone_stairs", new ModStairsBlock(SMOOTH_DIMSTONE));
        SMOOTH_DULLSTONE_SLAB = register("smooth_dullstone_slab", new SlabBlock(getProperties(SMOOTH_DULLSTONE)));
        SMOOTH_DULLSTONE_STAIRS = register("smooth_dullstone_stairs", new ModStairsBlock(SMOOTH_DULLSTONE));
        GLOWSTONE_BRICK_SLAB = register("glowstone_brick_slab", new SlabBlock(getProperties(GLOWSTONE_BRICK)));
        GLOWSTONE_BRICK_STAIRS = register("glowstone_brick_stairs", new ModStairsBlock(GLOWSTONE_BRICK));
        DIMSTONE_BRICK_SLAB = register("dimstone_brick_slab", new SlabBlock(getProperties(DIMSTONE_BRICK)));
        DIMSTONE_BRICK_STAIRS = register("dimstone_brick_stairs", new ModStairsBlock(DIMSTONE_BRICK));
        DULLSTONE_BRICK_SLAB = register("dullstone_brick_slab", new SlabBlock(getProperties(DULLSTONE_BRICK)));
        DULLSTONE_BRICK_STAIRS = register("dullstone_brick_stairs", new ModStairsBlock(DULLSTONE_BRICK));

        GLOWDUST = register("glowdust", new LayerBlock(getProperties(Blocks.SAND).lightLevel(12)));
        GLOWDUST_SAND = register("glowdust_sand", new SandBlock(0xFFC267, getProperties(GLOWDUST)));
        GLOWDUST_SANDSTONE = register("glowdust_sandstone", new Block(getProperties(Blocks.SANDSTONE).lightLevel(12)));
        CUT_GLOWDUST_SANDSTONE = register("cut_glowdust_sandstone", new Block(getProperties(GLOWDUST_SANDSTONE)));
        CHISELED_GLOWDUST_SANDSTONE = register("chiseled_glowdust_sandstone", new Block(getProperties(GLOWDUST_SANDSTONE)));
        GLOWDUST_SANDSTONE_SLAB = register("glowdust_sandstone_slab", new SlabBlock(getProperties(GLOWDUST_SANDSTONE)));
        GLOWDUST_SANDSTONE_STAIRS = register("glowdust_sandstone_stairs", new ModStairsBlock(GLOWDUST_SANDSTONE));

        GLIMMERING_BLACKSTONE = register("glimmering_blackstone", new Block(getProperties(Blocks.BLACKSTONE).lightLevel(value -> 12)));
    }

    private static Block register(String key, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(InfernalExpansion.MOD_ID, key), block);
    }

    private static FabricBlockSettings getProperties(Material materialIn, float hardnessAndResistanceIn) {
        return getProperties(materialIn, hardnessAndResistanceIn, hardnessAndResistanceIn);
    }

    private static FabricBlockSettings getProperties(Material materialIn, float hardnessIn, float resistanceIn) {
        return FabricBlockSettings.of(materialIn).hardness(hardnessIn).resistance(resistanceIn);
    }

    private static FabricBlockSettings getProperties(Block block) {
        return FabricBlockSettings.copyOf(block);
    }
}
