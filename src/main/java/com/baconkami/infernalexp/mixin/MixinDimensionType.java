package com.baconkami.infernalexp.mixin;

import com.baconkami.infernalexp.world.dimension.nether.ModNetherBiomeProvider;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorSettings;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DimensionType.class)
public class MixinDimensionType {

    @Inject(at = @At("HEAD"), method = "createNetherGenerator(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/Registry;J)Lnet/minecraft/world/gen/chunk/ChunkGenerator;", cancellable = true)
    private static void yeetTheNether(Registry<Biome> registry, Registry<ChunkGeneratorSettings> chunkGenRegistry, long seed, CallbackInfoReturnable<ChunkGenerator> cir) {
        if (FabricLoader.getInstance().isModLoaded("smolder") || FabricLoader.getInstance().isModLoaded("betternether")) {

        } else {
            cir.setReturnValue(new NoiseChunkGenerator(new ModNetherBiomeProvider(registry, seed), seed, () -> chunkGenRegistry.method_31140(ChunkGeneratorSettings.NETHER)));
        }
    }
}