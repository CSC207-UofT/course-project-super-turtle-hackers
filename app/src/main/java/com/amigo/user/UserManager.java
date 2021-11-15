package com.amigo.user;

import java.util.*;
import com.amigo.course.Course;
import com.amigo.match.Match;

/**
 * UserManager creates and manages users
 */
public class UserManager {

    private Map<String, User> users;
    private UserDatabase database;

    /**
     * Creates a UserManager using the users in the database and
     * maps the ids with the users into a hashmap
     */
    public UserManager(UserDatabase database) {
        this.database = database;
        List<User> userList = database.getUsers();
        users = new HashMap<>(userList.size());
        for (var each : userList) {
            // assuming id is unique
            users.put(each.getId(), each);
        }
    }

    /**
     * Returns a user id
     */
    public User getUserById(String id) {
        return users.get(id);
    }

    /**
     * Returns a hashmap of user ids mapped to the user
     */
    public Map<String, User> getUsers() {
        return users;
    }

    /**
     * Creates a new user
     * @param userInfo
     * @param writeToDatabase
     * @return the new user's id
     */
    public String createUser(String[] userInfo, boolean writeToDatabase) {
        String name = userInfo[0].strip();
        int year = Integer.parseInt(userInfo[1]);
        String prog = userInfo[2].strip();
        HashSet<Course> courses = createCourseSet(userInfo[3]);
        String contact = userInfo[4];
        Profile p = new Profile(name, year, prog, courses, contact);
        String id = name.split(" ")[0].toLowerCase() + (int) (1000 * Math.random() + 1);
        User user = new User(p, id);
        // TODO: not yet doing any checks of duplicates
        users.put(id, user);
        database.addUser(user);
        return id;
    }

    /**
     * Edits a user's name
     */
    public void editName (User user, String newName) {
        Profile userProfile = user.getProfile();
        userProfile.setName(newName);
    }

    /**
     * Edits a user's program of study
     */
    public void editProgramOfStudy (User user, String newProgram) {
        Profile userProfile = user.getProfile();
        userProfile.setProgramOfStudy(newProgram);
    }

    /**
     * Edits a user's year of study
     */
    public void editYearOfStudy (User user, int newYearOfStudy) {
        Profile userProfile = user.getProfile();
        userProfile.setYearOfStudy(newYearOfStudy);
    }

    /**
     * Adds a course to a user's profile
     */
    public void addCourses (User user, Course course) {
        Profile userProfile = user.getProfile();
        userProfile.addCourses(course);
    }

    /**
     * Removes a course from a user's profile
     */
    public void removeCourses(User user, String courseCode) {
        HashSet<Course> courses = user.getProfile().getCourses();
        courses.removeIf(course -> course.getCourseCode().equals(courseCode));
    }

    /**
     * Edits a user's contact info
     */
    public void editContactInfo (User user, String newContactInfo) {
        Profile userProfile = user.getProfile();
        userProfile.setContactInfo(newContactInfo);
    }

    /**
     * Creates a course set from input source
     *
     * THIS IS A DUPLICATE METHOD
     *
     * @param source
     * @return
     */
    private HashSet<Course> createCourseSet(String source) {
        String[] courseStrings = source.split(",");
        HashSet<Course> courseSet = new HashSet<Course>();
        for (var str : courseStrings) {
            Course c = new Course(str.strip());
            courseSet.add(c);
        }

        return courseSet;
    }

    /**
     * Modifies current matches for each user in matches
     * The currentMatches attribute for each user is first empties and then the new matches are
     * added.
     *
     * @param matches
     */
    public void modifyCurrentMatches(Map<String, List<Match>> matches) {
        // TODO: Add the previous current matches of each user to their match history
        for (var entry: matches.entrySet()) {
            User user = this.getUserById(entry.getKey());
            List<Match> currentMatchesUser = entry.getValue();
            user.setCurrentMatches(currentMatchesUser);
            // users.put(entry.getKey(), user);
        }
    }
}
