package cn.kevyn.kvc.blocks.contents.glass;

import cn.kevyn.kvc.blocks.contents.glass.patches.KVCGlassStairsBlock;
import cn.kevyn.kvc.blocks.patches.AllowSpawning;
import cn.kevyn.kvc.blocks.patches.RegisterHelper;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

import static cn.kevyn.kvc.blocks.contents.KVCGroups.KVC_BUILDING_BLOCKS;

public class KVCGlassStairs {

    private static List<Block> blocks;

    private static BlockState GLASS_BLOCKSTATE = Blocks.GLASS.getDefaultState();
    private static AbstractBlock.Settings GLASS_STAIRS_SETTINGS = FabricBlockSettings.copy(Blocks.GLASS).allowsSpawning(AllowSpawning::never);
    public static Block GLASS_STAIRS = new KVCGlassStairsBlock(GLASS_BLOCKSTATE, GLASS_STAIRS_SETTINGS);

    public static void doRegister() {

        RegisterHelper.registerBlockWithItem(GLASS_STAIRS, "glass_stairs", KVC_BUILDING_BLOCKS);
        blocks = RegisterHelper.registerBlocksByColor(GLASS_BLOCKSTATE, GLASS_STAIRS_SETTINGS, "_stained_glass_stairs");

    }

    public static void doClientInitialize() {

        BlockRenderLayerMap.INSTANCE.putBlock(GLASS_STAIRS, RenderLayer.getCutoutMipped());
        for (Block block : blocks) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
        }

    }

}
