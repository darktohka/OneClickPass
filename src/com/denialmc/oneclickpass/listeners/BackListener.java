package com.denialmc.oneclickpass.listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.denialmc.oneclickpass.guis.GUIManager;

@Getter @AllArgsConstructor
public class BackListener implements ActionListener {

	private Window window;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		window.setVisible(false);
		GUIManager.openWindow("main");
	}
}