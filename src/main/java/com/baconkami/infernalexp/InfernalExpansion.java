package com.baconkami.infernalexp;

import com.baconkami.infernalexp.data.ModDataGenerator;
import com.baconkami.infernalexp.world.dimension.nether.ModNetherBiomeProvider;
import com.baconkami.infernalexp.registries.ModBiomes;
import com.baconkami.infernalexp.registries.ModBlocks;
import com.baconkami.infernalexp.registries.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InfernalExpansion  implements ModInitializer {
    public static final String MOD_ID = "infernalexp";
    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Infernal Expansion...");
        ModNetherBiomeProvider.addNetherBiomesForProvider();
        Registry.register(Registry.BIOME_SOURCE, new Identifier(MOD_ID, "mod_nether"), ModNetherBiomeProvider.MODNETHERCODEC);
        //ModBlocks.registerBlocks();
        //ModItems.registerItems();
        //ModBiomes.registerNetherBiomes();
        ModDataGenerator.dataGenCommand();
        ModBiomes.addBiomeNumericalIDs();
        LOGGER.info("Infernal Expansion initialized!");
    }

    public static void bootStrap() {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModBiomes.registerNetherBiomes();
        ModBiomes.addBiomeNumericalIDs();
    }

    public static final ItemGroup TAB = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "infernaltab"))
            .icon(() -> new ItemStack(Items.GLOWSTONE))
            .build();
}
