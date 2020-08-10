package com.baconkami.infernalexp.world.biome;

import com.baconkami.infernalexp.registries.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class GlowstoneCanyonBiome extends Biome {
    public GlowstoneCanyonBiome() {
        super(new Biome.Settings()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(
                        ModBlocks.GLOWDUST_SAND.getDefaultState(),
                        ModBlocks.GLOWDUST_SANDSTONE.getDefaultState(),
                        ModBlocks.GLOWDUST_SANDSTONE.getDefaultState()
                ))
                .precipitation(Precipitation.NONE)
                .category(Category.NETHER)
                .depth(1.0F)
                .scale(1.0F)
                .temperature(2.0F)
                .downfall(0.0F)
                .effects(new BiomeEffects.Builder()
                        .waterColor(0x000000)
                        .waterFogColor(0x000000)
                        .fogColor(0xFFC267)
                        .build()
                )
        );
    }
}
