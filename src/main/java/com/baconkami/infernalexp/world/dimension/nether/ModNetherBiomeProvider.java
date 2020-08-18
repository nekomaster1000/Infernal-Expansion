package com.baconkami.infernalexp.world.dimension.nether;

import com.baconkami.infernalexp.registries.ModBiomes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;

import java.util.ArrayList;
import java.util.List;

public class ModNetherBiomeProvider extends BiomeSource {
    public static final Codec<ModNetherBiomeProvider> MODNETHERCODEC =
            RecordCodecBuilder.create((instance) -> instance.group(RegistryLookupCodec.of(Registry.BIOME_KEY)
                            .forGetter((theEndBiomeSource) -> theEndBiomeSource.biomeRegistry),
                    Codec.LONG.fieldOf("seed").stable().forGetter((theEndBiomeSource) -> theEndBiomeSource.seed))
                    .apply(instance, instance.stable(ModNetherBiomeProvider::new)));

    public static List<Biome> biomeList = new ArrayList<>();
    private final BiomeLayerSampler biomeLayer;
    private final long seed;
    private final Registry<Biome> biomeRegistry;

    public ModNetherBiomeProvider(Registry<Biome> registry, long seed) {
        super(biomeList);
        this.seed = seed;
        this.biomeLayer = ModNetherLayerProvider.stackLayers(seed);
        biomeRegistry = registry;
    }

    @Override
    protected Codec<? extends BiomeSource> getCodec() {
        return MODNETHERCODEC;
    }

    @Override
    public BiomeSource withSeed(long seed) {
        return new ModNetherBiomeProvider(biomeRegistry, seed);
    }

    @Override
    public Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ) {
        return biomeLayer.sample(biomeRegistry, biomeX, biomeZ);
    }

    public static void addNetherBiomesForProvider() {
        biomeList.add(ModBiomes.GLOWSTONE_CANYON);
    }
}
