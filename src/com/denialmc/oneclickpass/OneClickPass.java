package com.denialmc.oneclickpass;

import com.denialmc.oneclickpass.config.ConfigHandler;
import com.denialmc.oneclickpass.guis.GUIManager;
import com.denialmc.oneclickpass.guis.MainGUI;
import com.denialmc.oneclickpass.resources.ResourceHandler;

public class OneClickPass implements Runnable {

	@Override
	public void run() {
		ResourceHandler.extractResources();
		ConfigHandler.loadConfig();
		MainGUI main = new MainGUI();
		
		GUIManager.addWindow("main", main);
		GUIManager.openWindow(main);
	}
}
