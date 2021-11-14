package com.amigo.user;

import java.util.ArrayList;
import java.util.List;
// import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.amigo.match.Match;

@Entity
public class User {
    // TODO: Add a flag for report
    // TODO: Add a checkbox for Wildcard Matching
    private Profile profile;
    @Id
    // @Column(name = "id")
    private String id;
    private List<Match> currentMatches;
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

    public List<Match> getCurrentMatches() {return currentMatches;}

    public boolean equals(User user) {
        // If the ID of this user and the user is the same, then  return true
        return this.getId().equals(user.getId());
    }

    public void setCurrentMatches(List<Match> currentMatches) {
        this.currentMatches = currentMatches;
    }

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
