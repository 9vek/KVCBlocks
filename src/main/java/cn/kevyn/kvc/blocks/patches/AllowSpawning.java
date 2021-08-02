package cn.kevyn.kvc.blocks.patches;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class AllowSpawning {

    public static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    public static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }

}
