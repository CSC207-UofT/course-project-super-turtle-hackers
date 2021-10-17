package com.amigo.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

public class Matcher {
    /* Pseudo code for the matching algorithm
    * HashMap which maps each user to its potential matches
    * HashMap which maps each user to its matches
    * for each user in UserDatabase
    *   if each user >= 2 matches:
    *       skip
    *   else:
    *       ranks all of the users' potential matches using the metric each user
    *       then pick the user with the highest rank and match it with the original user
    */
    public HashMap<String, ArrayList<Match>> matching(ArrayList<User> users) {
        // Creates a map of potential matches
        HashMap<String, ArrayList<Match>> potentialMatches = this.potentialMatching(users);

        // Initializes the final map of matches
        HashMap<String, ArrayList<Match>> matches = new HashMap<>();
        for (User user: users) {
            matches.put(user.getId(), new ArrayList<>());
        }
        int minNumberMatches = 2;
        // A user could have less users if there are no available matches

        for (User user: users) {
            String userID = user.getId();
            ArrayList<Match> matchesUser = matches.get(userID);
            // If a user already has two matches or more, move on to next user
            if (matchesUser.size() >= minNumberMatches) {
                continue;
            }

            ArrayList<Match> potentialMatchesUser = potentialMatches.get(userID);
            // Sorts based on metric in descending order
            potentialMatchesUser.sort(new Comparator<Match>() {
                @Override
                public int compare(Match m1, Match m2) {
                    double val = (m1.getMetric() - m2.getMetric());
                    if (val > 0) {
                        return -1;
                    } else if (val == 0) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            });

            int i = 0;
            while (matchesUser.size() < minNumberMatches && i < potentialMatchesUser.size()) {
                Match potentialMatch = potentialMatchesUser.get(i);
                // Checks whether potentialMatch is already in matches
                boolean alreadyInserted = false;
                for (Match match: matchesUser) {
                    if (match.equals(potentialMatch)) {
                        alreadyInserted = true;
                        break;
                    }
                }
                if (!alreadyInserted) {
                    ArrayList<Match> otherUserMatches;
                    if (user.equals(potentialMatch.getUser1())) {
                        otherUserMatches = matches.get(potentialMatch.getUser2().getId());
                    } else {
                        otherUserMatches = matches.get(potentialMatch.getUser1().getId());
                    }
                    matchesUser.add(potentialMatch);
                    otherUserMatches.add(potentialMatch);
                }
                i ++;
            }
        }

        return matches;
    }

    private HashMap<String, ArrayList<Match>> potentialMatching(ArrayList<User> users) {
        // TODO: Add Wildcard Matches
        int numUsers = users.size();

        // Creates a map of potential matches
        HashMap<String, ArrayList<Match>> potentialMatches = new HashMap<>();
        for (User user: users) {
            potentialMatches.put(user.getId(), new ArrayList<>());
        }

        User user1;
        User user2;
        // Creates matches between each two users
        for (int i = 0; i < numUsers; i++) {
            user1 = users.get(i);
            for (int j = i + 1; j < numUsers; j++) {
                user2 = users.get(j);
                Match match = new Match(user1, user2, new Date(), metric(user1, user2));
                // Only adds the match if the two users have common courses
                if (match.getMetric() > 0){
                    potentialMatches.get(user1.getId()).add(match);
                    potentialMatches.get(user2.getId()).add(match);
                }
            }
        }
    return potentialMatches;
    }


    public double metric(User user1, User user2) {
        // TODO: Improve metric to include more than just courses
        Profile profile1 = user1.getProfile();
        Profile profile2 = user2.getProfile();

        // For now only the courses are taken into account for matching
        HashSet<Course> courses1 = profile1.getCourses();
        HashSet<Course> courses2 = profile2.getCourses();

        // For now only the course codes are used
        HashSet<String> courseCodes1 = new HashSet<>();
        HashSet<String> courseCodes2 = new HashSet<>();

        for (Course course: courses1) {
            courseCodes1.add(course.getCourseCode());
        }
        for (Course course: courses2) {
            courseCodes2.add(course.getCourseCode());
        }

        HashSet<String> commonCourseCodes = new HashSet<String>(courseCodes1);
        commonCourseCodes.retainAll(courseCodes2);  // takes the intersection
        double metric = ((double) commonCourseCodes.size()) / Math.min(courses1.size(), courses2.size());

        return metric;
    }

}
