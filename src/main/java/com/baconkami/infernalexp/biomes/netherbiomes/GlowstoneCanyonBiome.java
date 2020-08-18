package com.baconkami.infernalexp.biomes.netherbiomes;

import com.baconkami.infernalexp.biomes.BiomeHelper;
import com.baconkami.infernalexp.registries.ModSurfaceBuilders;
import net.minecraft.client.sound.MusicType;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class GlowstoneCanyonBiome extends Biome {
    static final ConfiguredSurfaceBuilder SURFACE_BUILDER = BiomeHelper.newConfiguredSurfaceBuilder("glowstone_canyon",
            new ConfiguredSurfaceBuilder<>(ModSurfaceBuilders.GLOWSTONE_CANYON, ModSurfaceBuilders.Config.GLOWSTONE_CANYON));
    static final Precipitation PRECIPATATION = Precipitation.NONE;
    static final Category CATEGORY = Category.NETHER;
    static final float DEPTH = 0.125F;
    static final float SCALE = 0.05F;
    static final float TEMPERATURE = 2.0F;
    static final float DOWNFALL = 0.0F;
    static final int WATER_COLOR = 0xF9B639;
    static final int WATER_FOG_COLOR = 0xF9B639;
    static final String PARENT = null;
    static final Weather WEATHER = new Weather(PRECIPATATION, TEMPERATURE, TemperatureModifier.NONE, DOWNFALL);
    static final SpawnSettings.Builder SPAWN_SETTINGS = new SpawnSettings.Builder();
    static final GenerationSettings.Builder GENERATION_SETTINGS = (new GenerationSettings.Builder()).surfaceBuilder(SURFACE_BUILDER)
            .carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE);

    public GlowstoneCanyonBiome() {
        super(WEATHER, CATEGORY, DEPTH, SCALE, (new BiomeEffects.Builder()).waterColor(WATER_COLOR).waterFogColor(WATER_FOG_COLOR)
                .fogColor(0xF9B639)
                .skyColor(BiomeHelper.calcSkyColor(2.0F))

                .loopSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_LOOP)
                .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_SOUL_SAND_VALLEY)
                ).build(), GENERATION_SETTINGS.build(), SPAWN_SETTINGS.build());
    }
}
