package com.amigo.logic;

import java.util.ArrayList;

public class User {
    // TODO: Add a flag for report
    // TODO: Add a checkbox for Wildcard Matching
    private Profile profile;
    private String id;
    private ArrayList<Match> currentMatches;
//    private matchHistory matchHistory; not used for phase 0

    public User(Profile profile, String id) {
        this.profile = profile;
        this.id = id;
        this.currentMatches = new ArrayList<Match>();
    }

    public Profile getProfile() {
        return profile;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Match> getCurrentMatches() {return currentMatches;}

    public boolean equals(User user) {
        // If the ID of this user and the user is the same, then  return true
        return this.getId().equals(user.getId());
    }
}
