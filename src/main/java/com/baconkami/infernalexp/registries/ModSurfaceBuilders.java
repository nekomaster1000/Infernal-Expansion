package com.baconkami.infernalexp.registries;

import com.baconkami.infernalexp.InfernalExpansion;
import com.baconkami.infernalexp.world.surfacebuilders.GlowstoneCanyonSurfaceBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ModSurfaceBuilders {
    public static SurfaceBuilder<TernarySurfaceConfig> GLOWSTONE_CANYON = register("glowstone_canyon", new GlowstoneCanyonSurfaceBuilder(TernarySurfaceConfig.CODEC));

    public static SurfaceBuilder register(String key, SurfaceBuilder<TernarySurfaceConfig> surfaceBuilder) {
        Registry.register(Registry.SURFACE_BUILDER, new Identifier(InfernalExpansion.MOD_ID, key), surfaceBuilder);
        return surfaceBuilder;
    }

    public static class Config {
        public static final TernarySurfaceConfig GLOWSTONE_CANYON = new TernarySurfaceConfig(
                ModBlocks.GLOWDUST_SAND.getDefaultState(),
                ModBlocks.GLOWDUST_SANDSTONE.getDefaultState(),
                ModBlocks.GLOWDUST_SANDSTONE.getDefaultState()
        );
    }
}
