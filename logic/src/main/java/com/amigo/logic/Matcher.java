package com.amigo.logic;

import java.util.ArrayList;
import java.util.HashSet;

public class Matcher {
    /* HashMap for each user
    * for each user in UserDatabase
    *   if each user == 2 matches:
    *       skip
    *   else:
    *
    *
    */

    public double metric(User user1, User user2) {
        Profile profile1 = user1.getProfile();
        Profile profile2 = user2.getProfile();

        // For now only the courses are taken into account for matching
        HashSet<Course> courses1 = profile1.getCourses();
        HashSet<Course> courses2 = profile2.getCourses();

        return 1;
    }

}
