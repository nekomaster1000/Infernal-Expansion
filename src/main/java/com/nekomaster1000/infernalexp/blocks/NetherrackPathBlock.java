package com.nekomaster1000.infernalexp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassPathBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class NetherrackPathBlock extends GrassPathBlock {

    public NetherrackPathBlock(Properties builder) {
        super(builder);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Block.nudgeEntitiesWithNewState(this.getDefaultState(), Blocks.NETHERRACK.getDefaultState(), context.getWorld(), context.getPos()) : super.getStateForPlacement(context);
    }

    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, Blocks.NETHERRACK.getDefaultState(), worldIn, pos));
    }
}
