package com.baconkami.infernalexp.world.dimension.nether;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.BuiltInBiomes;
import net.minecraft.world.biome.layer.type.InitLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public enum ModNetherMasterLayer implements InitLayer {
    INSTANCE;

    @Override
    public int sample(LayerRandomnessSource context, int x, int y) {
        return pickRandomBiomeID(context);
    }

    public int pickRandomBiomeID(LayerRandomnessSource randomnessSource) {
        if (ModNetherBiomeProvider.biomeList.isEmpty()) {
            return BuiltinRegistries.BIOME.getRawId(BuiltinRegistries.BIOME.get(BuiltInBiomes.NETHER_WASTES));
        }
        return BuiltinRegistries.BIOME.getRawId(ModNetherBiomeProvider.biomeList.get(randomnessSource.nextInt(ModNetherBiomeProvider.biomeList.size())));
    }
}
