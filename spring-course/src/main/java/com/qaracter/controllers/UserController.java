package com.qaracter.controllers;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qaracter.models.Credentials;
import com.qaracter.models.User;
import com.qaracter.services.AuthenticationService;
import com.qaracter.services.UserService;
import com.qaracter.utils.CredentialsUtils;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    
    private AuthenticationService authService;

    public UserController(UserService userService, AuthenticationService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> optUser = userService.getUserById(id);
        return optUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user, BindingResult result, HttpServletRequest request) {
    	if (result.hasErrors()) {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();    	
        }
    	
    	//retrieving the Authorization header
//    	String authorizationHeader = request.getHeader("Authorization");
    	
//    	Credentials userCredentials = CredentialsUtils.setCredentials(authorizationHeader);
    	
//    	if(authService.isLogged(userService.getUserByCredentials(userCredentials))) {
    		User createdUser = userService.createUser(user);
    		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
//    	}
    	
//    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {

        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        if (!userService.getUserById(id).isPresent()) {
            return ResponseEntity.ok("User with ID " + id + " not found!");
        } else {
            userService.deleteUser(id);
            return ResponseEntity.ok("User with ID " + id + " deleted successfully");

        }
    }
}