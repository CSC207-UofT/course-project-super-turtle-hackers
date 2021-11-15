package com.amigo.match;

import java.util.Date;
import com.amigo.user.User;

/**
 * A match between two users along with the percentage of match (metric) and the date of matching.
 */
public class Match {
    private User user1;
    private User user2;
    private Date dateOfMatch;
    private double metric;

    /**
     * Creates a match between two users with the date of match and the metric
     */
    public Match(User user1, User user2, Date dateOfMatch, double metric) {
        this.user1 = user1;
        this.user2 = user2;
        this.dateOfMatch = dateOfMatch;
        this.metric = metric;
    }

    /**
     * Returns the first user in the match
     */
    public User getUser1() {
        return user1;
    }

    /**
     * Returns the second user in the match
     */
    public User getUser2() {
        return user2;
    }

    /**
     * Returns the date of the match
     */
    public Date getDateOfMatch() {
        return dateOfMatch;
    }

    /**
     * Returns the percentage of match (metric)
     */
    public double getMetric() { return metric; }

    /**
     * Returns True if two Match objects are the same match or not based on the date they matched and
     * whether they contain the same first and second users. Returns False otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Match) {
            Match match = (Match) obj;
            boolean dateMatched = this.getDateOfMatch().equals(match.getDateOfMatch());
            User u1 = this.getUser1();
            User u2 = this.getUser2();
            User o1 = match.getUser1();
            User o2 = match.getUser2();
            boolean user1Matched = u1.equals(o1) || u1.equals(o2);
            boolean user2Matched = u2.equals(o1) || u2.equals(o2);

            return dateMatched && user1Matched && user2Matched;
        }
        else {
            return false;
        }
    }

}
