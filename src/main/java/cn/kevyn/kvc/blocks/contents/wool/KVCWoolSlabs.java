package cn.kevyn.kvc.blocks.contents.wool;

import cn.kevyn.kvc.blocks.patches.AllowSpawning;
import cn.kevyn.kvc.blocks.patches.RegisterHelper;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;

public class KVCWoolSlabs {

    private static AbstractBlock.Settings WOOL_STAIRS_SETTINGS = FabricBlockSettings.copyOf(Blocks.BLACK_WOOL)
            .allowsSpawning(AllowSpawning::never);

    public static void doRegister() {

        RegisterHelper.registerBlocksByColor(null, WOOL_STAIRS_SETTINGS, "_wool_slab");

    }

}
