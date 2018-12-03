package com.denialmc.oneclickpass.guis;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.denialmc.oneclickpass.config.AccountEntry;
import com.denialmc.oneclickpass.listeners.BackListener;
import com.denialmc.oneclickpass.listeners.ClipboardListener;

public class ChooseGUI extends JFrame {

	public ChooseGUI(AccountEntry account) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0, 3));
		setTitle(String.format("Choose - %s", account.getSite()));
		setMinimumSize(new Dimension(400, 400));
		
		JButton back = new JButton("Back");
		JButton username = new JButton("Copy Username");
		JButton password = new JButton("Copy Password");
		
		back.addActionListener(new BackListener(this));
		username.addActionListener(new ClipboardListener(account.getUsername()));
		password.addActionListener(new ClipboardListener(account.getPassword()));
		add(back);
		add(username);
		add(password);
		pack();
	}
}