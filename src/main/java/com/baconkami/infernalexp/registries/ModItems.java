package com.baconkami.infernalexp.registries;

import com.baconkami.infernalexp.InfernalExpansion;
import com.baconkami.infernalexp.blocks.ModStairsBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {
    public static Item DIMSTONE;
    public static Item DULLSTONE;
    public static Item SMOOTH_GLOWSTONE;
    public static Item SMOOTH_DIMSTONE;
    public static Item SMOOTH_DULLSTONE;
    public static Item GLOWSTONE_BRICK;
    public static Item DIMSTONE_BRICK;
    public static Item DULLSTONE_BRICK;
    public static Item CHISELED_GLOWSTONE_BRICK;
    public static Item CHISELED_DIMSTONE_BRICK;
    public static Item CHISELED_DULLSTONE_BRICK;
    public static Item SMOOTH_GLOWSTONE_SLAB;
    public static Item SMOOTH_GLOWSTONE_STAIRS;
    public static Item SMOOTH_DIMSTONE_SLAB;
    public static Item SMOOTH_DIMSTONE_STAIRS;
    public static Item SMOOTH_DULLSTONE_SLAB;
    public static Item SMOOTH_DULLSTONE_STAIRS;
    public static Item GLOWSTONE_BRICK_SLAB;
    public static Item GLOWSTONE_BRICK_STAIRS;
    public static Item DIMSTONE_BRICK_SLAB;
    public static Item DIMSTONE_BRICK_STAIRS;
    public static Item DULLSTONE_BRICK_SLAB;
    public static Item DULLSTONE_BRICK_STAIRS;

    public static void registerAll() {
        DIMSTONE = register("dimstone", ModBlocks.DIMSTONE);
        DULLSTONE = register("dullstone", ModBlocks.DULLSTONE);
        SMOOTH_GLOWSTONE = register("smooth_glowstone", ModBlocks.SMOOTH_GLOWSTONE);
        SMOOTH_DIMSTONE = register("smooth_dimstone", ModBlocks.SMOOTH_DIMSTONE);
        SMOOTH_DULLSTONE = register("smooth_dullstone", ModBlocks.SMOOTH_DULLSTONE);
        GLOWSTONE_BRICK = register("glowstone_brick", ModBlocks.GLOWSTONE_BRICK);
        DIMSTONE_BRICK = register("dimstone_brick", ModBlocks.DIMSTONE_BRICK);
        DULLSTONE_BRICK = register("dullstone_brick", ModBlocks.DULLSTONE_BRICK);
        CHISELED_GLOWSTONE_BRICK = register("chiseled_glowstone_brick", ModBlocks.CHISELED_GLOWSTONE_BRICK);
        CHISELED_DIMSTONE_BRICK = register("chiseled_dimstone_brick", ModBlocks.CHISELED_DIMSTONE_BRICK);
        CHISELED_DULLSTONE_BRICK = register("chiseled_dullstone_brick", ModBlocks.CHISELED_DULLSTONE_BRICK);
        SMOOTH_GLOWSTONE_SLAB = register("smooth_glowstone_slab", ModBlocks.SMOOTH_GLOWSTONE_SLAB);
        SMOOTH_GLOWSTONE_STAIRS = register("smooth_glowstone_stairs", ModBlocks.SMOOTH_GLOWSTONE_STAIRS);
        SMOOTH_DIMSTONE_SLAB = register("smooth_dimstone_slab", ModBlocks.SMOOTH_DIMSTONE_SLAB);
        SMOOTH_DIMSTONE_STAIRS = register("smooth_dimstone_stairs", ModBlocks.SMOOTH_DIMSTONE_STAIRS);
        SMOOTH_DULLSTONE_SLAB = register("smooth_dullstone_slab", ModBlocks.SMOOTH_DULLSTONE_SLAB);
        SMOOTH_DULLSTONE_STAIRS = register("smooth_dullstone_stairs", ModBlocks.SMOOTH_DULLSTONE_STAIRS);
        GLOWSTONE_BRICK_SLAB = register("glowstone_brick_slab", ModBlocks.GLOWSTONE_BRICK_SLAB);
        GLOWSTONE_BRICK_STAIRS = register("glowstone_brick_stairs", ModBlocks.GLOWSTONE_BRICK_STAIRS);
        DIMSTONE_BRICK_SLAB = register("dimstone_brick_slab", ModBlocks.DIMSTONE_BRICK_SLAB);
        DIMSTONE_BRICK_STAIRS = register("dimstone_brick_stairs", ModBlocks.DIMSTONE_BRICK_STAIRS);
        DULLSTONE_BRICK_SLAB = register("dullstone_brick_slab", ModBlocks.DULLSTONE_BRICK_SLAB);
        DULLSTONE_BRICK_STAIRS = register("dullstone_brick_stairs", ModBlocks.DULLSTONE_BRICK_STAIRS);
    }

    private static Item register(String key, Block block) {
        Item item = new BlockItem(block, getProperties());
        Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, key), item);
        return item;
    }

    private static Item register(String key, Item item) {
        Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, key), item);
        return item;
    }

    private static Item.Settings getProperties() {
        return new Item.Settings().group(InfernalExpansion.TAB);
    }
}
