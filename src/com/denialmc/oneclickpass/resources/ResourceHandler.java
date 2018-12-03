package com.denialmc.oneclickpass.resources;

import java.io.File;
import java.nio.file.Files;

import lombok.Getter;

import com.denialmc.oneclickpass.Bootstrap;

public class ResourceHandler {

	@Getter private static final String[] resources = new String[] {"settings.json"};
	
	public static void extractResources() {
		ClassLoader loader = Bootstrap.class.getClassLoader();
		
		for (String resource : resources) {
			try {
				File file = new File(resource);
				
				if (!file.exists()) {
					Files.copy(loader.getResourceAsStream(resource), file.getAbsoluteFile().toPath());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}