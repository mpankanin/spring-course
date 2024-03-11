package com.qaracter.models;

import javax.validation.constraints.*;

import java.util.Date;
import java.util.Set;

public class User {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String username;

    @NotBlank
    @Size(min = 4)
    private String password;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;
    
    private Date lastLogin;

    private Role role;

    private Set<Task> tasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

	public Set<Task> getTasks() {
		return tasks;
	}
    
    

}
