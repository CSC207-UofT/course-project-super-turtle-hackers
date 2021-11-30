package com.amigo.match;

import java.util.*;

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
        // Creates a map of potential matches
        Map<String, List<Match>> potentialMatches = this.matchPotential(users);

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

            List<Match> potentialMatchesUser = potentialMatches.get(userID);
            // Sorts based on metric in descending order
            potentialMatchesUser.sort((m1, m2) -> {
                double val = (m1.getMetric() - m2.getMetric());
                if (val > 0) {
                    return -1;
                } else if (val == 0) {
                    return 0;
                } else {
                    return 1;
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
                    List<Match> otherUserMatches;
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
                if (match.getMetric() > 0){
                    potentialMatches.get(user1.getId()).add(match);
                    potentialMatches.get(user2.getId()).add(match);
                }
            }
        }
        return potentialMatches;
    }

    /**
     * Returns the metric representing the closeness of match between two users.
     * +1 for same course
     * +1 for same year of study
     * +1 for same program of study
     * -1 for year of study difference > 1
     */
    public double metric(User user1, User user2) {
        // TODO: Improve metric to include more than just courses, should be done
        double temp_metric = 0;
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

        // Take into account two profiles in the same year of study
        int yearOfStudy1 = profile1.getYearOfStudy();
        int yearOfStudy2 = profile2.getYearOfStudy();
        if (yearOfStudy1 == yearOfStudy2){
            temp_metric = 1;
        }
        // Difference in year of studies accounted for
        if (Math.abs(yearOfStudy1 - yearOfStudy2) > 1){
            temp_metric = -1;
        }
        double metric = temp_metric;
        temp_metric = 0;

        String ProgramOfStudy1 = profile1.getProgramOfStudy().toLowerCase();
        String ProgramOfStudy2 = profile2.getProgramOfStudy().toLowerCase();
        if (ProgramOfStudy1.equals(ProgramOfStudy2)){
            temp_metric = 1;
        }
        // Check if there is a one letter typo in the spellings
        else if (differ_by_one(ProgramOfStudy1, ProgramOfStudy2)){
            temp_metric = 1;
        }
        // Handle any alternative spellings
        else if (alternative_spelling(ProgramOfStudy1, ProgramOfStudy2)){
            temp_metric = 1;
        }
        metric += temp_metric;

            HashSet<String> commonCourseCodes = new HashSet<>(courseCodes1);
        commonCourseCodes.retainAll(courseCodes2);  // takes the intersection
        metric = metric + ((double) commonCourseCodes.size()) / Math.min(courses1.size(), courses2.size());

        return metric;
    }
    /**
     * Returns whether the two inputs differ by one letter
     */
    static boolean differ_by_one(String word1, String word2) {
        if(word1.length() == word2.length()) {
            int mistake = (int) Math.ceil((double)word1.length()/5); // Allow only 20% error in typing
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    mistake--;
                    if (mistake < 0) { // If there are more than two differences when the words are equal lengh then return false
                        return false;
                    }
                }
            }
        }
        else{
            if (check_added_character(word2, word1, !differ_by_one(word1, word2))) return true;
            if (check_added_character(word1, word2, !differ_by_one(word1, word2))) return true;
        }
        return true;
    }
    // Check if the words are alternates of each other if the additional letter is removed, at every index
    private static boolean check_added_character(String word1, String word2, boolean b) {
        if(word2.length() - word1.length() == 1){
            for (int i = 0; i < word2.length(); i++){
                StringBuilder temp = new StringBuilder(word2);
                temp.deleteCharAt(i);
                word2 = temp.toString();
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns whether there are two equivalent spellings for programs of study
     */
    static boolean alternative_spelling(String word1, String word2) {
        if ((word1.equals("cs")||differ_by_one(word1, "cs")) && (word2.equals("computer science")||differ_by_one(word2, "computer science"))){
            return true;
        }
        else if ((word1.equals("computer science")||differ_by_one(word1, "computer science")) && (word2.equals("cs")||differ_by_one(word2, "cs"))){
            return true;
        }
        else if ((word1.equals("chem")||differ_by_one(word1, "chem")) && (word2.equals("chemistry")||differ_by_one(word2, "chemistry"))){
            return true;
        }
        else if ((word1.equals("chemistry")||differ_by_one(word1, "chemistry")) && (word2.equals("chem")||differ_by_one(word2, "chem"))){
            return true;
        }
        else if ((word1.equals("engsci")||differ_by_one(word1, "engsci")) && (word2.equals("engineering science")||differ_by_one(word2, "engineering science"))){
            return true;
        }
        else if ((word1.equals("engineering science")||differ_by_one(word1, "engineering science")) && (word2.equals("engsci")||differ_by_one(word2, "engsci"))){
            return true;
        }
        else if ((word1.equals("chemeng")||differ_by_one(word1, "chemeng")) && (word2.equals("chemical engineering")||differ_by_one(word2, "chemical engineering"))){
            return true;
        }
        else if ((word1.equals("mecheng")||differ_by_one(word1, "mecheng")) && (word2.equals("mechanical engineering")||differ_by_one(word2, "mechanical engineering"))){
            return true;
        }
        else if ((word1.equals("mechanical engineering")||differ_by_one(word1, "mechanical engineering")) && (word2.equals("mecheng")||differ_by_one(word2, "mecheng"))){
            return true;
        }
        else if ((word1.equals("cogsci")||differ_by_one(word1, "cogsci")) && (word2.equals("cognitive science")||differ_by_one(word2, "cognitive science"))){
            return true;
        }
        else if ((word1.equals("cognitive science")||differ_by_one(word1, "cognitive science")) && (word2.equals("cogsci")||differ_by_one(word2, "cogsci"))){
            return true;
        }
        else if ((word1.equals("IR")||differ_by_one(word1, "IR")) && (word2.equals("international relations")||differ_by_one(word2, "international relations"))){
            return true;
        }
        else if ((word1.equals("international relations")||differ_by_one(word1, "international relations")) && (word2.equals("IR")||differ_by_one(word2, "IR"))){
            return true;
        }
        else if ((word1.equals("international relations")||differ_by_one(word1, "international relations")) && (word2.equals("IR")||differ_by_one(word2, "IR"))){
            return true;
        }
        else if ((word1.equals("math")||differ_by_one(word1, "math")) && (word2.equals("mathematics")||differ_by_one(word2, "mathematics"))){
            return true;
        }
        else return (word1.equals("mathematics") || differ_by_one(word1, "mathematics")) && (word2.equals("math") || differ_by_one(word2, "math"));
    }
    }

