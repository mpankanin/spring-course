package com.qaracter.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Credentials {

	@NotNull
	@NotEmpty
	private String username;
	
	@NotNull
	@NotEmpty
	private String password;
	
	private String authCode;

	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Credentials() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Credentials){
			Credentials credentials = (Credentials) obj;
            return this.username.equals(credentials.getUsername()) &&  this.password.equals(credentials.getPassword());
        }
        return false;
	}

}
