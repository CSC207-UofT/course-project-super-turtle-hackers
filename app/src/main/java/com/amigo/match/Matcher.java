package com.amigo.match;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.amigo.user.User;
import com.amigo.user.Profile;
import com.amigo.course.Course;

public class Matcher {

    /**
     * Returns a map containing the list of final matches for each user in
     * {@code users}. Below is the pseudocode for the matching algorithm.
     *
     * <pre>
     * for each user in UserDatabase
     *   if each user >= 2 matches:
     *       skip
     *   else:
     *       ranks all of the users' potential matches using the metric each user
     *       then pick the user with the highest rank and match it with the original user
     * </pre>
     */
    public Map<String, List<Match>> match(List<User> users) {
        int maxNumberMatches = 4;
        // Creates a map of potential matches
        Map<String, List<Match>> userTopMatches = this.getTopMatches(users, maxNumberMatches);

        // Initializes the final map of matches
        Map<String, List<Match>> matches = new HashMap<>();
        for (User user: users) {
            matches.put(user.getId(), new ArrayList<>());
        }

        int minNumberMatches = 2;
        // A user could have less matches if there are no available matches


        for (User user: users) {
            String userID = user.getId();
            List<Match> matchesUser = matches.get(userID);
            // If a user already has two matches or more, move on to next user
            if (matchesUser.size() >= minNumberMatches) {
                continue;
            }

            List<Match> topMatchesUser = userTopMatches.get(userID);

            int i = 0;
            while (i < topMatchesUser.size()) {
                Match potentialMatch = topMatchesUser.get(i);
                // Checks whether potentialMatch is already in matches
                boolean alreadyInserted = false;
                for (Match match: matchesUser) {
                    if (match.equals(potentialMatch)) {
                        alreadyInserted = true;
                        break;
                    }
                }
                if (!alreadyInserted) {
                    List<Match> otherUserMatches;
                    User otherUser;
                    if (user.equals(potentialMatch.getUser1())) {
                        otherUser = potentialMatch.getUser2();
                        otherUserMatches = matches.get(potentialMatch.getUser2().getId());
                    } else {
                        otherUser = potentialMatch.getUser1();
                        otherUserMatches = matches.get(potentialMatch.getUser1().getId());
                    }
                    List<Match> otherUserTopMatches = userTopMatches.get(otherUser.getId());
                    if (otherUserTopMatches.contains(potentialMatch) && otherUserMatches.size() < 4) {
                        matchesUser.add(potentialMatch);
                        otherUserMatches.add(potentialMatch);
                    }
                }
                i ++;
            }
        }

        return matches;
    }

    /**
     * Returns a map containing the list of all potential matches for each user in
     * {@code users}. Each possible pair of users is evaluated by a metric function.
     */
    private Map<String, List<Match>> matchPotential(List<User> users) {
        // TODO: Add Wildcard Matches
        int numUsers = users.size();

        // Creates a map of potential matches
        Map<String, List<Match>> potentialMatches = new HashMap<>();
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

    /**
     * Returns a map containing the list of all top matches for each user in
     * {@code users}. Each possible pair of users is evaluated by a metric function.
     */
    private Map<String, List<Match>> getTopMatches(List<User> users, int numTopMatches) {
        Map<String, List<Match>> topMatches = new HashMap<>();
        Map<String, List<Match>> potentialMatches = matchPotential(users);
        for (User user : users) {
            List<Match> userTopMatches;
            List<Match> userPotentialMatches = potentialMatches.get(user.getId());
            userPotentialMatches.sort(new Comparator<Match>() {
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
            if (userPotentialMatches.size() >= 4) {
                userTopMatches = userPotentialMatches.subList(0, numTopMatches);
            } else {
                userTopMatches = userPotentialMatches;
            }
            topMatches.put(user.getId(), userTopMatches);
            }
        return topMatches;
        }


    /**
     * Returns the metric representing the closeness of match between two users.
     */
    public double metric(User user1, User user2) {
        // TODO: Improve metric to include more than just courses
        double metric;
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

        HashSet<String> commonCourseCodes = new HashSet<>(courseCodes1);
        commonCourseCodes.retainAll(courseCodes2);  // takes the intersection
        metric = ((double) commonCourseCodes.size()) / Math.min(courses1.size(), courses2.size());

        return metric;
    }

}
