package com.amigo.logic;

import java.util.Date;

public class Match {
    private User user1;
    private User user2;
    private Date dateOfMatch;
    private double metric;

    public Match(User user1, User user2, Date dateOfMatch, double metric) {
        this.user1 = user1;
        this.user2 = user2;
        this.dateOfMatch = dateOfMatch;
        this.metric = metric;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public Date getDateOfMatch() {
        return dateOfMatch;
    }

    public double getMetric() { return metric; }

    public boolean equals(Match match) {
        boolean dateMatched = this.getDateOfMatch().equals(match.getDateOfMatch());
        User u1 = this.getUser1();
        User u2 = this.getUser2();
        User o1 = match.getUser1();
        User o2 = match.getUser2();
        boolean user1Matched = u1.equals(o1) || u1.equals(o2);
        boolean user2Matched = u2.equals(o1) || u2.equals(o2);

        return dateMatched && user1Matched && user2Matched;
    }

}
