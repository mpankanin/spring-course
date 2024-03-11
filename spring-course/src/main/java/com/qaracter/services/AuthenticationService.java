package com.qaracter.services;

import com.qaracter.models.Credentials;
import com.qaracter.models.User;

public interface AuthenticationService {

	public boolean isAuthorized(User user);
	
	public boolean isLogged(User user);

	public Credentials login(User user);

}
