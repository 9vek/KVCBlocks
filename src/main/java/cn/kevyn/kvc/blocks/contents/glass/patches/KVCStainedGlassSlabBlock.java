package cn.kevyn.kvc.blocks.contents.glass.patches;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class KVCStainedGlassSlabBlock extends KVCGlassSlabBlock implements Stainable {

    private final DyeColor color;

    public KVCStainedGlassSlabBlock(DyeColor color, Settings settings) {
        super(settings);
        this.color = color;
    }

    @Override
    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState blockState_1, BlockState blockState_2, Direction direction_1) {
        Block block_2 = blockState_2.getBlock();

        if (block_2 instanceof StainedGlassBlock
                && ((StainedGlassBlock) block_2).getColor() == color)
            return true;

        if (block_2 == this)
            if (isInvisibleToGlassSlab(blockState_1, blockState_2, direction_1))
                return true;

        if (block_2 instanceof KVCStainedGlassStairsBlock
                && ((KVCStainedGlassStairsBlock) block_2).getColor() == color)
            if (isInvisibleToGlassStairs(blockState_1, blockState_2,
                    direction_1))
                return true;

        return super.isSideInvisible(blockState_1, blockState_2, direction_1);
    }


    @Override
    public DyeColor getColor() {
        return color;
    }

}
