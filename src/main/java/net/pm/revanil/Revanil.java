package net.pm.revanil;

import net.fabricmc.api.ModInitializer;

import net.pm.revanil.client.particle.RParticles;
import net.pm.revanil.world.item.RItemGroups;
import net.pm.revanil.world.item.RItems;
import net.pm.revanil.world.level.block.RBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Revanil implements ModInitializer {
	public static final String MOD_ID = "revanil";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RBlocks.init();
		RItems.init();
		RItemGroups.init();
		RParticles.init();
	}
}