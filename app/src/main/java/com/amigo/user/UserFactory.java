package com.amigo.user;

/**
 * Factory that curates form input and creates a {@code User} object.
 */
@Deprecated
public class UserFactory {

    /**
     * Generates a random ID for a Profile and create a User using the Profile and ID.
     * @param profile a Profile object that contains all the information of the user
     * @return a new User object
     */
    @Deprecated
    public User createUser(Profile profile) {
        String name = profile.getName();
        String id = name.split(" ")[0].toLowerCase() + (int) (1000 * Math.random() + 1);
        String email = "maeve@gmail.com";
        String password = "password123";
        return new User(profile, id, email, password);
    }

}
