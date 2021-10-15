package com.amigo.logic;

import java.time.LocalDateTime;

public class Match {
    private User user1;
    private User user2;
    private LocalDateTime timeOfMatch;

    public Match(User user1, User user2, LocalDateTime timeOfMatch) {
        this.user1 = user1;
        this.user2 = user2;
        this.timeOfMatch = timeOfMatch;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public LocalDateTime getTimeOfMatch() {
        return timeOfMatch;
    }
}
