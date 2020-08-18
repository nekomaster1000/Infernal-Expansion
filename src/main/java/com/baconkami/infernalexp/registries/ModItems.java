package com.baconkami.infernalexp.registries;

import com.baconkami.infernalexp.InfernalExpansion;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModItems {
    // Block Items
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
    public static Item GLOWDUST;
    public static Item GLOWDUST_SAND;
    public static Item GLOWDUST_SANDSTONE;
    public static Item CUT_GLOWDUST_SANDSTONE;
    public static Item CHISELED_GLOWDUST_SANDSTONE;
    public static Item GLOWDUST_SANDSTONE_SLAB;
    public static Item GLOWDUST_SANDSTONE_STAIRS;

    // Items
    public static Item GLOWCOAL;

    public static void registerItems() {
        InfernalExpansion.LOGGER.info("Infernal Expansion: Registering items...");
        // Block Items
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
        GLOWDUST = register("glowdust", ModBlocks.GLOWDUST);
        GLOWDUST_SAND = register("glowdust_sand", ModBlocks.GLOWDUST_SAND);
        GLOWDUST_SANDSTONE = register("glowdust_sandstone", ModBlocks.GLOWDUST_SANDSTONE);
        CUT_GLOWDUST_SANDSTONE = register("cut_glowdust_sandstone", ModBlocks.CUT_GLOWDUST_SANDSTONE);
        CHISELED_GLOWDUST_SANDSTONE = register("chiseled_glowdust_sandstone", ModBlocks.CHISELED_GLOWDUST_SANDSTONE);
        GLOWDUST_SANDSTONE_SLAB = register("glowdust_sandstone_slab", ModBlocks.GLOWDUST_SANDSTONE_SLAB);
        GLOWDUST_SANDSTONE_STAIRS = register("glowdust_sandstone_stairs", ModBlocks.GLOWDUST_SANDSTONE_STAIRS);

        GLOWCOAL = register("glowcoal", new Item(getProperties()));
        FuelRegistry.INSTANCE.add(GLOWCOAL, 1600);

        InfernalExpansion.LOGGER.info("Infernal Expansion: Items registered!");
    }

    private static Item register(String key, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, key), new BlockItem(block, getProperties()));
    }

    private static Item register(String key, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(InfernalExpansion.MOD_ID, key), item);
    }

    private static Item.Settings getProperties() {
        return new Item.Settings().group(InfernalExpansion.TAB);
    }
}
