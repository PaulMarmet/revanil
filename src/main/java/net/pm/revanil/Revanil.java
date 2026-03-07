package net.pm.revanil;

import net.fabricmc.api.ModInitializer;

import net.pm.revanil.item.RItemGroups;
import net.pm.revanil.item.RItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Revanil implements ModInitializer {
	public static final String MOD_ID = "revanil";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		RItems.init();
		RItemGroups.init();
	}
}