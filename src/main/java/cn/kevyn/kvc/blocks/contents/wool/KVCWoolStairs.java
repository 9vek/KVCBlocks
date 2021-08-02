package cn.kevyn.kvc.blocks.contents.wool;

import cn.kevyn.kvc.blocks.patches.AllowSpawning;
import cn.kevyn.kvc.blocks.patches.RegisterHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class KVCWoolStairs {

    private static BlockState WOOL_BLOCKSTATE = Blocks.BLACK_WOOL.getDefaultState();
    private static AbstractBlock.Settings WOOL_STAIRS_SETTINGS = FabricBlockSettings.copy(Blocks.BLACK_WOOL).allowsSpawning(AllowSpawning::never);

    public static void doRegister() {

        RegisterHelper.registerBlocksByColor(WOOL_BLOCKSTATE, WOOL_STAIRS_SETTINGS, "_wool_stairs");

    }

}
