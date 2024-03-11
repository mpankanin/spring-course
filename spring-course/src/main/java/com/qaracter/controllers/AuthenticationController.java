package com.qaracter.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qaracter.models.Credentials;
import com.qaracter.models.User;
import com.qaracter.services.AuthenticationService;
import com.qaracter.services.UserService;


@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
	
	private UserService userService;
	    
    private AuthenticationService authService;

    public AuthenticationController(UserService userService, AuthenticationService authService) {
        this.userService = userService;
        this.authService = authService;
    }


	@PostMapping("/login")
    public ResponseEntity<Credentials> login(@RequestBody Credentials credentials, BindingResult result) {
    	if (result.hasErrors()) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();    	
        }
    	
    	User currentUser = userService.getUserByCredentials(credentials);
		if(currentUser != null) {    	
			Credentials updatedCredentials = authService.login(currentUser);
    		return ResponseEntity.status(HttpStatus.CREATED).body(updatedCredentials);
    	}
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
