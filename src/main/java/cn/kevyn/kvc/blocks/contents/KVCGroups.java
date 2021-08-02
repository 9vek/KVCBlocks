package cn.kevyn.kvc.blocks.contents;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class KVCGroups {

    /** 物品组 */
    public static final ItemGroup KVC_BUILDING_BLOCKS = FabricItemGroupBuilder.build(new Identifier("minecraft", "kms_building_blocks"), () -> new ItemStack(Blocks.WARPED_PLANKS));

}
