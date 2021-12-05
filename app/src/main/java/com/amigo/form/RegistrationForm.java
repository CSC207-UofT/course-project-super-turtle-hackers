package com.amigo.form;

/**
 * Data class that gets created when a user submits a registration form.
 */

public class RegistrationForm {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;

    /**
     * Returns the email
     */

    public String getEmail() {
        return email;
    }

    /**
     * Creates an email
     */

    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Returns the first name
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Creates a first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Returns the last name
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Creates a last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Returns the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Creates a password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Returns the confirmed password
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }
    /**
     * Create a confirmed password
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
