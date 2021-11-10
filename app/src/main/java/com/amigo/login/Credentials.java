package com.amigo.login;

/**
 * User credentials for login.
 * 
 * <p> The value of each instance variable is populated by Thymeleaf, corresponding to the
 * credentials that the user inputs into the login form.
 */
public class Credentials {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // must provide setter for Thymeleaf to inject value
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
