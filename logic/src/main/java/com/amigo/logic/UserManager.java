package com.amigo.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class UserManager {

    private Map<String, User> users;
    private UserDatabase database;

    public UserManager(UserDatabase database) {
        this.database = database;
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
