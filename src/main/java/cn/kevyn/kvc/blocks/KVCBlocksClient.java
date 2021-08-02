package cn.kevyn.kvc.blocks;

import cn.kevyn.kvc.blocks.contents.glass.KVCGlassSlabs;
import cn.kevyn.kvc.blocks.contents.glass.KVCGlassStairs;
import net.fabricmc.api.ClientModInitializer;

public class KVCBlocksClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        /** 楼梯 */
        KVCGlassStairs.doClientInitialize();

        /** 半砖 */
        KVCGlassSlabs.doClientInitialize();

    }

}
