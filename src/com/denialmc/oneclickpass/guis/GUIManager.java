package com.denialmc.oneclickpass.guis;

import java.awt.Window;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class GUIManager {

	@Getter private static Map<String, Window> windows = new HashMap<String, Window>();
	
	static {
		windows.put("settings", new SettingsGUI());
	}
	
	public static void disableWindows() {
		for (Window window : windows.values()) {
			window.setVisible(false);
		}
	}
	
	public static void openWindow(Window window) {
		disableWindows();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	}
	
	public static void openWindow(String name) {
		Window window = getWindow(name);
		
		if (window != null) {
			openWindow(window);
		}
	}
	
	public static Window getWindow(String name) {
		return windows.get(name);
	}
	
	public static void addWindow(String name, Window window) {
		windows.put(name, window);
	}
	
	public static void removeWindow(String name) {
		windows.remove(name);
	}
}