package com.qaracter.utils;

import java.util.Base64;

import com.qaracter.models.Credentials;
import com.qaracter.models.User;

public class CredentialsUtils {

	public static Credentials setCredentials(String authorizationHeader) {
		//splitting the Authorization header, isolating the Base64Code
    	String[] splittedAuth = authorizationHeader.split(" ");
    	String base64Code = splittedAuth[1];
    	
    	// Decode the Base64 encoded string
        byte[] decodedBytes = Base64.getDecoder().decode(base64Code);
        
        // Convert the decoded bytes back to a string
        String userPass = new String(decodedBytes);
        
        //separating username and password
        String[] splittedUserPass = userPass.split(":");
        String username = splittedUserPass[0];
        String password = splittedUserPass[1];
        
        return new Credentials(username, password);
	}
	
	public static Credentials getCredentialsByUser(User user) {
		Credentials credentials = new Credentials();
		if(user != null) {
			credentials.setUsername(user.getUsername());
			credentials.setPassword(user.getPassword());
			
			// Concatenate username and password with a colon
	        String authString = user.getUsername() + ":" + user.getPassword();
	        
	        // Encode the concatenated string in Base64
	        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
	        
	        credentials.setAuthCode("Basic " + encodedAuthString);
	        
		}
		return credentials;
	}
	
}
