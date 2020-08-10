package com.baconkami.infernalexp.registries;

import com.baconkami.infernalexp.InfernalExpansion;
import com.baconkami.infernalexp.world.biome.GlowstoneCanyonBiome;
import net.fabricmc.fabric.api.biomes.v1.NetherBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static Biome GLOWSTONE_CANYON;

    public static void registerAll() {
        GLOWSTONE_CANYON = register("glowstone_canyon", new GlowstoneCanyonBiome());
    }

    private static Biome register(String key, Biome biome) {
        Registry.register(Registry.BIOME, new Identifier(InfernalExpansion.MOD_ID, key), biome);
        NetherBiomes.addNetherBiome(biome);
        return biome;
    }
}
