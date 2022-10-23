package cn.kevyn.kvc.blocks.contents.concrete;

import cn.kevyn.kvc.blocks.patches.AllowSpawning;
import cn.kevyn.kvc.blocks.patches.RegisterHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;


public class KVCConcreteStairs {

    private static BlockState CONCRETE_BLOCKSTATE = Blocks.BLACK_CONCRETE.getDefaultState();
    private static AbstractBlock.Settings CONCRETE_STAIRS_SETTINGS = FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)
            .allowsSpawning(AllowSpawning::never)
            .requiresTool();

    public static void doRegister() {

        RegisterHelper.registerBlocksByColor(CONCRETE_BLOCKSTATE, CONCRETE_STAIRS_SETTINGS, "_concrete_stairs");

    }

}
