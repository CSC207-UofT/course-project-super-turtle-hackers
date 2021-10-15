package com.amigo.logic;

import java.util.ArrayList;
import java.util.HashSet;

public class Matcher {
    /* Pseudo code for the matching algorithm
    * HashMap which maps each user to its matches
    * for each user in UserDatabase
    *   if each user >= 2 matches:
    *       skip
    *   else:
    *       rank each user other than the user itself and the users that are already matched
    *       with the user
    *       then pick the user with the highest rank and match it with the original user
    */

    public Matcher(UserDatabase userdb) {
        this.userdb = userdb;
    }

    public double metric(User user1, User user2) {
        Profile profile1 = user1.getProfile();
        Profile profile2 = user2.getProfile();

        // For now only the courses are taken into account for matching
        HashSet<Course> courses1 = profile1.getCourses();
        HashSet<Course> courses2 = profile2.getCourses();

        HashSet<Course> commonCourses = new HashSet<Course>(courses1);
        commonCourses.retainAll(courses2);  // takes the intersection

        return commonCourses.size();
    }

}
