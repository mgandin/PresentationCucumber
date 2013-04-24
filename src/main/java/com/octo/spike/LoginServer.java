package com.octo.spike;

import java.util.HashMap;

public class LoginServer {

	private HashMap<String , String> users;
	
	private static LoginServer instance;
    private String currentLogin;
	
	private LoginServer() {		
			users = new HashMap<String, String>();
	}
	
	public static LoginServer getInstance() {
		if(instance == null) {
			instance = new LoginServer();
		}
		return instance;
	}
	
	public void createUser(String login, String password) {
		if(password.length() > 5) {
			users.put(login, password);
		}
	}

	public String messageLogin() {
		return "Hello " + currentLogin;
	}

	public boolean connect(String login, String password) {
        this.currentLogin = login;
		return (users.containsKey(login) && users.containsValue(password));
	}
}
