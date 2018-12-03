package com.denialmc.oneclickpass.guis;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.denialmc.oneclickpass.config.AccountEntry;
import com.denialmc.oneclickpass.config.Config;
import com.denialmc.oneclickpass.config.ConfigHandler;

public class MainGUI extends JFrame {

	public MainGUI() {
		Config config = ConfigHandler.getConfig();
		
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setLayout(new GridLayout(2, 0));
		setTitle(String.format("Welcome, %s!", config.getName()));
		setMinimumSize(new Dimension(400, 100));
		
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		getContentPane().add(panel);
		
		JList<String> list = new JList<String>(config.getAccountSites());
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					String value = list.getSelectedValue();
					
					if (value != null) {
						AccountEntry account = config.getAccount(value);
						
						if (account != null) {
							GUIManager.openWindow(new ChooseGUI(account));
						}
					}
				}
			}
		});
		panel.add(list);
		pack();
	}
}