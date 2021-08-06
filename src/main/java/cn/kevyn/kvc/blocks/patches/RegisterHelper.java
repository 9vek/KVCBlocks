package cn.kevyn.kvc.blocks.patches;

import cn.kevyn.kvc.blocks.contents.glass.patches.KVCStainedGlassStairsBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

import static cn.kevyn.kvc.blocks.contents.KVCGroups.KVC_BUILDING_BLOCKS;

public class RegisterHelper {

    public static final  String[] COLORS = {
            "white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray",
            "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"
    };

    public static List<Block> registerBlocksByColor(BlockState blockState, AbstractBlock.Settings settings, String suffix) {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < COLORS.length; i++) {
            Block block = null;
            if (suffix.contains("stairs")) {
                if (suffix.contains("stained_glass")) {
                    block = new KVCStainedGlassStairsBlock(blockState, settings, DyeColor.byName(COLORS[i], null));
                }
                else block = new KVCStairsBlock(blockState, settings);
            }
            else if (suffix.contains("slab")) {
                block = new KVCSlabBlock(settings);
            }
            registerBlockWithItem(block, COLORS[i]+suffix, KVC_BUILDING_BLOCKS);
            blocks.add(block);
        }
        return blocks;
    }

    public static void registerBlockWithItem(Block block, String id, ItemGroup group) {
        Identifier identifier = new Identifier("minecraft", id);
        BlockItem blockItem = new BlockItem(block, new FabricItemSettings().group(group));
        Registry.register(Registry.BLOCK, identifier, block);
        Registry.register(Registry.ITEM, identifier, blockItem);
    }

}
