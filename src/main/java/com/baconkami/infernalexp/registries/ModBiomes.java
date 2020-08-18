package com.baconkami.infernalexp.registries;

//import com.baconkami.infernalexp.world.biome.GlowstoneCanyonBiome;
import com.baconkami.infernalexp.InfernalExpansion;
import com.baconkami.infernalexp.biomes.netherbiomes.GlowstoneCanyonBiome;
import com.baconkami.infernalexp.world.dimension.nether.ModNetherBiomeProvider;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.event.registry.RegistryEntryRemovedCallback;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.SetBaseBiomesLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ModBiomes {
    public static List<Biome> biomeList = new ArrayList<>();
    public static Biome GLOWSTONE_CANYON = new GlowstoneCanyonBiome();

    public static void registerNetherBiomes() {
        InfernalExpansion.LOGGER.info("Infernal Expansion: Registering biomes...");
        registerNetherBiome("glowstone_canyon", GLOWSTONE_CANYON);
        BuiltinRegistries.BIOME.stream().filter(biome -> biome.getCategory().equals(Biome.Category.NETHER)).forEach(biome -> ModNetherBiomeProvider.biomeList.add(biome));
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((rawId, id, biome) -> {
            if (biome.getCategory().equals(Biome.Category.NETHER)) {
                ModNetherBiomeProvider.biomeList.add(biome);
            }
        });
        // this should never happen, but just in case...
        RegistryEntryRemovedCallback.event(BuiltinRegistries.BIOME).register((rawid, id, biome) -> {
            ModNetherBiomeProvider.biomeList.removeIf(biome::equals);
        });
        InfernalExpansion.LOGGER.info("Infernal Expansion: Biomes registered!");
    }

    private static void registerNetherBiome(String key, Biome biome) {
        Registry.register(BuiltinRegistries.BIOME, new Identifier(InfernalExpansion.MOD_ID, key), biome);
        biomeList.add(biome);
    }

    public static void addBiomeNumericalIDs() {
        for (Biome biome : biomeList) {
            Optional<RegistryKey<Biome>> key = BuiltinRegistries.BIOME.getKey(biome);
            if (key.isPresent())
                key.ifPresent(biomeRegistryKey -> Biomes.BIOMES.put(BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.method_31140(key.get())), biomeRegistryKey));
        }
    }
}
