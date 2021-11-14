package com.amigo.user;

public class UserFactory{
    /**
     * Constructs for UserFactory.
     */
    public UserFactory() {
    }

    /**
     * Generates a random ID for a Profile and create a User using the Profile and ID.
     * @param profile a Profile object that contains all the information of the user
     * @return a new User object
     */
    public User createUser(Profile profile) {
        String name = profile.getName();
        String id = name.split(" ")[0].toLowerCase() + (int) (1000 * Math.random() + 1);
        return new User(profile, id);
    }
}
