package com.baconkami.infernalexp.world.gen.surfacebuilders;

import com.baconkami.infernalexp.registries.ModBlocks;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.AbstractNetherSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class GlowstoneCanyonSurfaceBuilder extends AbstractNetherSurfaceBuilder {
    private static final BlockState GLOWDUST_SAND;
    private static final BlockState GLOWDUST_SANDSTONE;
    private static final BlockState GLOWSTONE;
    private static final ImmutableList<BlockState> field_23924;

    public GlowstoneCanyonSurfaceBuilder(Codec<TernarySurfaceConfig> codec) {
        super(codec);
    }

    protected ImmutableList<BlockState> method_27129() {
        return field_23924;
    }

    protected ImmutableList<BlockState> method_27133() {
        return field_23924;
    }

    protected BlockState method_27135() {
        return GLOWSTONE;
    }

    static {
        GLOWDUST_SAND = ModBlocks.GLOWDUST_SAND.getDefaultState();
        GLOWDUST_SANDSTONE = ModBlocks.GLOWDUST_SANDSTONE.getDefaultState();
        GLOWSTONE = Blocks.GLOWSTONE.getDefaultState();
        field_23924 = ImmutableList.of(GLOWDUST_SAND, GLOWDUST_SANDSTONE);
    }
}
