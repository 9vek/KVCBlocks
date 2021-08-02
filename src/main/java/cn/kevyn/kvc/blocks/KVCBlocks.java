package cn.kevyn.kvc.blocks;

import cn.kevyn.kvc.blocks.contents.concrete.KVCConcreteSlabs;
import cn.kevyn.kvc.blocks.contents.concrete.KVCConcreteStairs;
import cn.kevyn.kvc.blocks.contents.glass.KVCGlassSlabs;
import cn.kevyn.kvc.blocks.contents.glass.KVCGlassStairs;
import cn.kevyn.kvc.blocks.contents.wool.KVCWoolSlabs;
import cn.kevyn.kvc.blocks.contents.wool.KVCWoolStairs;
import net.fabricmc.api.ModInitializer;

public class KVCBlocks implements ModInitializer {

	@Override
	public void onInitialize() {

		/** 羊毛楼梯 */
		KVCWoolStairs.doRegister();

		/** 羊毛台阶 */
		KVCWoolSlabs.doRegister();

		/** 混凝土楼梯 */
		KVCConcreteStairs.doRegister();

		/** 混凝土楼梯 */
		KVCConcreteSlabs.doRegister();

		/** 楼梯注册 */
		KVCGlassStairs.doRegister();

		/** 台阶注册 */
		KVCGlassSlabs.doRegister();

	}
}
