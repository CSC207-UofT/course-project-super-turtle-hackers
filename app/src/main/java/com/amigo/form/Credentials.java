package com.amigo.form;

/**
 * User credentials for login.
 * 
 * <p> The value of each instance variable is populated by Thymeleaf, corresponding to the
 * credentials that the user inputs into the login form.
 */
public class Credentials {
    private String username;
    private String password;

    /**
     * Returns the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password
     */
    public String getPassword() {
        return password;
    }

    // must provide setter for Thymeleaf to inject value
    /**
     * Creates a username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Creates a password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
