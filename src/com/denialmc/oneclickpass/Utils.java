package com.denialmc.oneclickpass;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import lombok.Getter;

import com.google.gson.Gson;

public class Utils {

	@Getter private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Getter private static final Gson gson = new Gson();
	
	public static String readFile(String path) {
		try {
			return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String formatDate(long milliseconds, String level, String message) {
		return String.format("%s [%s] %s\n", date.format(milliseconds), level, message);
	}
}