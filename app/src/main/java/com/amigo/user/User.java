package com.amigo.user;

import java.util.ArrayList;
import java.util.List;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.amigo.match.Match;

/**
 * A user containing an id, a profile and a list of current matches.
 */
@Entity
public class User {
    // TODO: Add a flag for report-made binary int
    // TODO: Add a checkbox for Wildcard Matching
    private Profile profile;
    @Id
    // @Column(name = "id")
    private String id;
    private List<Match> currentMatches;
    private int flag;
//    private matchHistory matchHistory; not used for phase 0

    /**
     * Creates a user using the default constructor
     */
    public User() {}

    /**
     * Creates a user containing an id, a profile and an empty list of current matches.
     */
    public User(Profile profile, String id) {
        this.profile = profile;
        this.id = id;
        this.currentMatches = new ArrayList<>();
        this.flag = 0;
    }

    /**
     * Returns a user's profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Returns a user's id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns a list of a user's current matches
     */
    public List<Match> getCurrentMatches() {return currentMatches;}
    public int getFlag(){
        return flag;
    }
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
    public void flag(){
        this.flag = 1;
    }
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
}
