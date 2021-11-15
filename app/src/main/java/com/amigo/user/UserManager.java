package com.amigo.user;

import java.util.*;
import com.amigo.course.Course;
import com.amigo.course.CourseSetFactory;
import com.amigo.match.Match;

public class UserManager {

    private Map<String, User> users;
    private final UserDatabase database;
    private final UserFactory userFactory;
    private final ProfileFactory profileFactory;
    private final CourseSetFactory courseSetFactory;

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

    public User getUserById(String id) {
        return users.get(id);
    }

    public Map<String, User> getUsers() {
        return users;
    }

    /**
     *
     * @param userInfo
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
//        String id = name.split(" ")[0].toLowerCase() + (int) (1000 * Math.random() + 1);
        User user = userFactory.createUser(p);
        // TODO: not yet doing any checks of duplicates
        users.put(user.getId(), user);
        database.addUser(user);
        return user.getId();
    }

    public void editName (User user, String newName) {
        Profile userProfile = user.getProfile();
        userProfile.setName(newName);
    }

    public void editProgramOfStudy (User user, String newProgram) {
        Profile userProfile = user.getProfile();
        userProfile.setProgramOfStudy(newProgram);
    }

    public void editYearOfStudy (User user, int newYearOfStudy) {
        Profile userProfile = user.getProfile();
        userProfile.setYearOfStudy(newYearOfStudy);
    }

    public void addCourses (User user, Course course) {
        Profile userProfile = user.getProfile();
        userProfile.addCourses(course);
    }

    public void removeCourses(User user, String courseCode) {
        HashSet<Course> courses = user.getProfile().getCourses();
        courses.removeIf(course -> course.getCourseCode().equals(courseCode));
    }

    public void editContactInfo (User user, String newContactInfo) {
        Profile userProfile = user.getProfile();
        userProfile.setContactInfo(newContactInfo);
    }

    /**
     * Modifies current matches for each user in matches
     * The currentMatches attribute for each user is first empties and then the new matches are
     * added.
     *
     * @param matches
     */
    public void modifyCurrentMatches(HashMap<String, ArrayList<Match>> matches) {
        // TODO: Add the previous current matches of each user to their match history
        for (Map.Entry<String, ArrayList<Match>> entry: matches.entrySet()) {
            User user = this.getUserById(entry.getKey());
            ArrayList<Match> currentMatchesUser = entry.getValue();
            user.setCurrentMatches(currentMatchesUser);
            // users.put(entry.getKey(), user);
        }
    }
}
