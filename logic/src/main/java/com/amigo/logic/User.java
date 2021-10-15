package com.amigo.logic;

public class User {
    private Profile profile;
    private String id;
//    private matchHistory matchHistory; not used for phase 0

    public User(Profile profile, String id) {
        this.profile = profile;
        this.id = id;
    }
}
