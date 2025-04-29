package net.zhiga.randomstuff;

import net.fabricmc.api.ModInitializer;

import net.zhiga.randomstuff.Item.ModItems;
import net.zhiga.randomstuff.armor.ModArmor;
import net.zhiga.randomstuff.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomStuff implements ModInitializer {
	public static final String MOD_ID = "randomstuff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("[RandomStuff] Starting Random-Stuff-Mod");
		ModItems.registerModItems();
		ModBlocks.registerModBlock();
		ModArmor.registerModArmor();
	}
}