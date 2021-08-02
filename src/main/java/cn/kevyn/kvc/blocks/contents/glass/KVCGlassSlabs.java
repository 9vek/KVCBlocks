package cn.kevyn.kvc.blocks.contents.glass;

import cn.kevyn.kvc.blocks.contents.KVCGroups;
import cn.kevyn.kvc.blocks.contents.glass.patches.KVCGlassSlabBlock;
import cn.kevyn.kvc.blocks.contents.glass.patches.KVCStainedGlassSlabBlock;
import cn.kevyn.kvc.blocks.patches.AllowSpawning;
import cn.kevyn.kvc.blocks.patches.RegisterHelper;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.Stainable;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class KVCGlassSlabs {

    public static final Block GLASS_SLAB = new KVCGlassSlabBlock(AbstractBlock.Settings.of(Material.GLASS)
                    .strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque()
                    .allowsSpawning(AllowSpawning::never).solidBlock(AllowSpawning::never)
                    .suffocates(AllowSpawning::never).blockVision(AllowSpawning::never));

    public static final KVCStainedGlassSlabBlock WHITE_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.WHITE);
    public static final KVCStainedGlassSlabBlock ORANGE_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.ORANGE);
    public static final KVCStainedGlassSlabBlock MAGENTA_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.MAGENTA);
    public static final KVCStainedGlassSlabBlock LIGHT_BLUE_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.LIGHT_BLUE);
    public static final KVCStainedGlassSlabBlock YELLOW_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.YELLOW);
    public static final KVCStainedGlassSlabBlock LIME_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.LIME);
    public static final KVCStainedGlassSlabBlock PINK_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.PINK);
    public static final KVCStainedGlassSlabBlock GRAY_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.GRAY);
    public static final KVCStainedGlassSlabBlock LIGHT_GRAY_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.LIGHT_GRAY);
    public static final KVCStainedGlassSlabBlock CYAN_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.CYAN);
    public static final KVCStainedGlassSlabBlock PURPLE_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.PURPLE);
    public static final KVCStainedGlassSlabBlock BLUE_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.BLUE);
    public static final KVCStainedGlassSlabBlock BROWN_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.BROWN);
    public static final KVCStainedGlassSlabBlock GREEN_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.GREEN);
    public static final KVCStainedGlassSlabBlock RED_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.RED);
    public static final KVCStainedGlassSlabBlock BLACK_STAINED_GLASS_SLAB =
            createStainedGlassSlab(DyeColor.BLACK);

    public static final KVCStainedGlassSlabBlock[] STAINED_GLASS_SLABS =
            {WHITE_STAINED_GLASS_SLAB, ORANGE_STAINED_GLASS_SLAB,
                    MAGENTA_STAINED_GLASS_SLAB, LIGHT_BLUE_STAINED_GLASS_SLAB,
                    YELLOW_STAINED_GLASS_SLAB, LIME_STAINED_GLASS_SLAB,
                    PINK_STAINED_GLASS_SLAB, GRAY_STAINED_GLASS_SLAB,
                    LIGHT_GRAY_STAINED_GLASS_SLAB, CYAN_STAINED_GLASS_SLAB,
                    PURPLE_STAINED_GLASS_SLAB, BLUE_STAINED_GLASS_SLAB,
                    BROWN_STAINED_GLASS_SLAB, GREEN_STAINED_GLASS_SLAB,
                    RED_STAINED_GLASS_SLAB, BLACK_STAINED_GLASS_SLAB};

    private static KVCStainedGlassSlabBlock createStainedGlassSlab(DyeColor color) {
        return new KVCStainedGlassSlabBlock(color, AbstractBlock.Settings.of(Material.GLASS, color).strength(0.3F)
                        .sounds(BlockSoundGroup.GLASS).nonOpaque()
                        .allowsSpawning(AllowSpawning::never).solidBlock(AllowSpawning::never)
                        .suffocates(AllowSpawning::never).blockVision(AllowSpawning::never));
    }

    private static void register(Block block, String idPath, ItemGroup itemGroup) {

        Identifier identifier = new Identifier("minecraft", idPath);
        Registry.register(Registry.BLOCK, identifier, block);
        Item.Settings itemSettings = new Item.Settings().group(itemGroup);
        BlockItem blockItem = new BlockItem(block, itemSettings);
        Registry.register(Registry.ITEM, identifier, blockItem);

    }

    public static void doRegister() {

        register(GLASS_SLAB, "glass_slab", KVCGroups.KVC_BUILDING_BLOCKS);
        for(int i = 0; i < 16; i++) register(STAINED_GLASS_SLABS[i], RegisterHelper.COLORS[i] + "_stained_glass_slab", KVCGroups.KVC_BUILDING_BLOCKS);

    }

    private static void clientInitialize(Block block) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, block instanceof Stainable ? RenderLayer.getTranslucent() : RenderLayer.getCutoutMipped());
    }

    public static void doClientInitialize() {

        clientInitialize(GLASS_SLAB);
        for(int i = 0; i < 16; i++) clientInitialize(STAINED_GLASS_SLABS[i]);

    }

}

