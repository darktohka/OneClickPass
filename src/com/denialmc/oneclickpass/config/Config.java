package com.denialmc.oneclickpass.config;

import lombok.Getter;

@Getter
public class Config {

	private String name;
	private AccountEntry[] accounts;
	
	public String[] getAccountSites() {
		int length = accounts.length;
		String[] sites = new String[length];
		
		for (int i = 0; i < length; i++) {
			sites[i] = accounts[i].getSite();
		}
		
		return sites;
	}
	
	public AccountEntry getAccount(String site) {
		for (AccountEntry account : accounts) {
			if (account.getSite().equals(site)) {
				return account;
			}
		}
		
		return null;
	}
}