/*
 * Copyright (C) 2019 - 2020 | Alexander01998 | All rights reserved.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package cn.kevyn.kvc.blocks.contents.glass.patches;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public final class KVCStainedGlassStairsBlock extends KVCGlassStairsBlock implements Stainable {
    private final DyeColor color;

	public KVCStainedGlassStairsBlock(BlockState blockState, Settings settings, DyeColor color) {
		super(blockState, settings);
		this.color = color;
	}


	@Override
    @Environment(EnvType.CLIENT)
    public boolean isSideInvisible(BlockState blockState_1, BlockState blockState_2, Direction direction_1) {
        Block block_2 = blockState_2.getBlock();

        if (block_2 instanceof StainedGlassBlock
                && ((StainedGlassBlock) block_2).getColor() == color)
            return true;

        if (block_2 instanceof KVCStainedGlassSlabBlock
                && ((KVCStainedGlassSlabBlock) block_2).getColor() == color)
            if (isInvisibleToGlassSlab(blockState_1, blockState_2, direction_1))
                return true;

        if (block_2 == this)
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
