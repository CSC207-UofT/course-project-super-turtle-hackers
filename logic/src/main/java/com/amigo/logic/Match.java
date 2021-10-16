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

    public double getMetric() {
        return metric;
    }
}
