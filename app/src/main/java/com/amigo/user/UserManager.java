package com.amigo.user;

import java.util.*;
import com.amigo.course.Course;
import com.amigo.course.CourseSetFactory;
import com.amigo.match.Match;

/**
 * UserManager creates and manages users
 */
public class UserManager {

    private Map<String, User> users;
    private final UserDatabase database;
    private final UserFactory userFactory;
    private final ProfileFactory profileFactory;
    private final CourseSetFactory courseSetFactory;

    /**
     * Constructs UserManager, and creates and store UserFactory, ProfileFactory and CourseSetFactory objects, and
     * creates Map of users and id.
     * @param database database that stores users
     */
    public UserManager(UserDatabase database) {
        this.database = database;
        this.userFactory = new UserFactory();
        this.profileFactory = new ProfileFactory();
        this.courseSetFactory = new CourseSetFactory();
        List<User> userList = database.getUsers();
        users = new HashMap<>(userList.size());
        for (var each : userList) {
            // assuming id is unique
            users.put(each.getId(), each);
        }
    }

    /**
     * Retrieves and returns User using the unique identification.
     * @param id the unique identification of each User
     * @return User with the id
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
     * Creates a new user using information given.
     * @param userInfo string containing user's information
     * @param writeToDatabase
     * @return the new user's id
     */
    public String createUser(String[] userInfo, boolean writeToDatabase) {
        String name = userInfo[0].strip();
        int year = Integer.parseInt(userInfo[1]);
        String prog = userInfo[2].strip();
        HashSet<Course> courses = courseSetFactory.createCourseSet(userInfo[3]);
        String contact = userInfo[4];
        Profile p = profileFactory.createProfile(name, year, prog, courses, contact);
        User user = userFactory.createUser(p);
        // TODO: not yet doing any checks of duplicates
        users.put(user.getId(), user);
        database.addUser(user);
        return user.getId();
    }

    /**
     * Modifies the User's name with the new name.
     * @param user User object that is to be modified
     * @param newName the new name
     */
    public void editName (User user, String newName) {
        Profile userProfile = user.getProfile();
        userProfile.setName(newName);
    }

    /**
     * Modifies the User's program of study.
     * @param user User object that is to be modified
     * @param newProgram the new program
     */
    public void editProgramOfStudy (User user, String newProgram) {
        Profile userProfile = user.getProfile();
        userProfile.setProgramOfStudy(newProgram);
    }

    /**
     * Modifies the User's year of study
     * @param user User object that is to be modified
     * @param newYearOfStudy the new year of study
     */
    public void editYearOfStudy (User user, int newYearOfStudy) {
        Profile userProfile = user.getProfile();
        userProfile.setYearOfStudy(newYearOfStudy);
    }

    /**
     * Adds a new course to the user profile
     * @param user User object that is to be modified
     * @param course Course object to be added
     */
    public void addCourses (User user, Course course) {
        Profile userProfile = user.getProfile();
        userProfile.addCourses(course);
    }

    /**
     * Removes a course from the user profile
     * @param user User object that is to be modified
     * @param courseCode Course code of course to be removed
     */
    public void removeCourses(User user, String courseCode) {
        HashSet<Course> courses = user.getProfile().getCourses();
        courses.removeIf(course -> course.getCourseCode().equals(courseCode));
    }

    /**
     * Modifies the User's contact information
     * @param user User object that is to be modified
     * @param newContactInfo new contact information
     */
    public void editContactInfo (User user, String newContactInfo) {
        Profile userProfile = user.getProfile();
        userProfile.setContactInfo(newContactInfo);
    }

    /**
     * Modifies current matches for each user in matches
     * The currentMatches attribute for each user is first empties and then the new matches are
     * added.
     *
     * @param matches Map of users and their matches
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
