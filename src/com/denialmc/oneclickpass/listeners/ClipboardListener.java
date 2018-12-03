package com.denialmc.oneclickpass.listeners;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class ClipboardListener implements ActionListener {

	private String message;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(message), null);
	}
}