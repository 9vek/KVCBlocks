package cn.kevyn.kvc.blocks.contents.concrete;

import cn.kevyn.kvc.blocks.patches.AllowSpawning;
import cn.kevyn.kvc.blocks.patches.RegisterHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;

public class KVCConcreteSlabs {

    private static AbstractBlock.Settings CONCRETE_STAIRS_SETTINGS = FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE)
            .allowsSpawning(AllowSpawning::never)
            .requiresTool();

    public static void doRegister() {

        RegisterHelper.registerBlocksByColor(null, CONCRETE_STAIRS_SETTINGS, "_concrete_slab");

    }

}
