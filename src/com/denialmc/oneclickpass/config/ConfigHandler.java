package com.denialmc.oneclickpass.config;

import lombok.Getter;

import com.denialmc.oneclickpass.Utils;

public class ConfigHandler {

	@Getter private static Config config;
	
	public static void loadConfig() {
		String json = Utils.readFile("settings.json");
		
		if (json != null) {
			try {
				config = Utils.getGson().fromJson(json, Config.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}