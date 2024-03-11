package com.qaracter.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.qaracter.models.Credentials;
import com.qaracter.models.User;
import com.qaracter.services.AuthenticationService;
import com.qaracter.services.UserService;
import com.qaracter.utils.CredentialsUtils;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

	UserService userService;
	
	public AuthenticationServiceImp(UserService userService) {
        this.userService = userService;
    }

	@Override
	public boolean isAuthorized(User user) {
		
		//to be implemented
				
		return true;
	}
	
	@Override
	public boolean isLogged(User user) {
		LocalDateTime sevenDaysAgoLDT = LocalDate.now().minusDays(7).atTime(LocalTime.now());
		
		Date sevenDaysAgo = Date.from(sevenDaysAgoLDT.atZone(ZoneId.systemDefault()).toInstant());
		if(user.getLastLogin() != null) {			
			return user.getLastLogin().after(sevenDaysAgo);
		}
		
		return false;
		
	}


	@Override
	public Credentials login(User user) {
		Credentials credentials = CredentialsUtils.getCredentialsByUser(user);
		if(!isLogged(user)) {
			user.setLastLogin(new Date());
			userService.updateUser(user.getId(), user);
		}
		return credentials;
	}

}
