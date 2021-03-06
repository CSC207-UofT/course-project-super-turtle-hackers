package com.amigo.user;

import java.util.ArrayList;
import java.util.List;

import com.amigo.match.Match;

/**
 * A user containing an id, an email, a password, a profile and a list of current matches.
 */
public class User {
    private Profile profile;
    private String id;
    private String email;
    private String password;

    private List<Match> currentMatches;
    private int flag;
    private boolean checkbox;

    /**
     * Creates a user using the default constructor
     */
    public User() {
        this.currentMatches = new ArrayList<>();
    }

    /**
     * Creates a user containing an id, an email, a password, a profile and an empty list of current matches.
     */
    public User(Profile profile, String id, String email, String password) {
        this.profile = profile;
        this.id = id;
        this.currentMatches = new ArrayList<>();
        this.flag = 0;
        this.email = email;
        this.password = password;
    }

    /**
     * Returns a user's profile
     */
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    /**
     * Returns a user's id
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns a user's email
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns a list of a user's current matches
     */
    public List<Match> getCurrentMatches() {return currentMatches;}
    public int getFlag(){
        return flag;
    }
    public boolean getCheckbox(){return checkbox;}
    /**
     * Returns True if the id of a given user is the same as the current user
     */
    public boolean equals(User user) {
        // If the ID of this user and the user is the same, then  return true
        return this.getId().equals(user.getId());
    }

    /**
     * Updates the list of current matches with the given list
     */
    public void setCurrentMatches(List<Match> currentMatches) {
        this.currentMatches = currentMatches;
    }
    public void setFlag(){
        this.flag = 1;
    }
    public void removeFlag(){this.flag = 0;}
    public void setCheckbox(){this.checkbox = true;}
    public void removeCheckbox(){this.checkbox = false;}
    /**
     * Returns the name of the matched user of the current user.
     */
    public String toStringCurrentMatches() {
        ArrayList<String> namesCurrentMatches = new ArrayList<>();
        for (Match match: this.currentMatches) {
            String otherUser;
            if (this.equals(match.getUser1())) {
                otherUser = match.getUser2().getProfile().getName();
            } else {
                otherUser = match.getUser1().getProfile().getName();
            }
            namesCurrentMatches.add(otherUser);
        }
        return namesCurrentMatches.toString();
    }
    /**
     * Creates a password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns whether the user object has been properly instantiated and has its
     * attributes set.
     */
    public boolean isValid() {
        return profile != null;
    }
}
