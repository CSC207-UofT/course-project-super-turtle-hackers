package com.amigo.logic;

public class User {
    private Profile profile;
    private String id;
//    private matchHistory matchHistory; not used for phase 0

    public User(Profile profile, String id) {
        this.profile = profile;
        this.id = id;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getId() {
        return id;
    }

    public boolean equals(User user) {
        // If the ID of this user and the user is the same, then  return true
        return this.getId().equals(user.getId());
    }
}
