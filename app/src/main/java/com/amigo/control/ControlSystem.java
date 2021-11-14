package com.amigo.control;

import com.amigo.logic.ui.TUI;
import com.amigo.user.*;
import com.amigo.match.*;
import com.amigo.course.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControlSystem {

    private TUI ui;
    private UserManager manager;

    public ControlSystem() {
        UserDatabase db = new UserTextDatabase();
        manager = new UserManager(db);
        ui = new TUI();
    }

    /**
     * Runs the app internal logic.
     * 
     */
    public void run() {
        String response = ui.runWelcome();
        if (response.equals("y")) {
            login();
        }
        else {
            register();
        }
        this.doMatching();
        ArrayList<User> users = new ArrayList<>(this.manager.getUsers().values());
        for (User user : users) {
            Profile profile = user.getProfile();
            System.out.println(profile.getName() + ": " + user.toStringCurrentMatches());
        }
    }

    /**
     * Modifies user info in memory but does not write into database.
     *
     * @param user  A user to be edited
     */
    private void edit(User user) {
        String response = ui.runEdit();
        if (response.equals("y")) {
            String editItem = ui.chooseEdit();
            if (editItem.equals("1")) {
                editUserName(user);
            }
            else if (editItem.equals("2")) {
                editProgramOfStudy(user);
            }
            else if (editItem.equals("4")) {
                editContactInfo(user);
            }
            else {
                editCourses(user);
            }
        }
    }

    /**
     * Adds or removes courses from main.
     * 
     * @param user  A user whose courses are to be edited
     */
    private void editCourses(User user) {
        String addOrRemoveCourse = ui.inputAddOrRemoveCourse();
        if (addOrRemoveCourse.equals("1")) {
            String newCourseCode = ui.inputNewCourse();
            manager.addCourses(user, new Course(newCourseCode));
        }
        else {
            String removeCourseCode = ui.inputRemoveCourse();
            manager.removeCourses(user, removeCourseCode);
        }
    }

    /**
     * Edits user's contact info.
     * 
     * @param user  A user whose contact info is to be edited
     */
    private void editContactInfo(User user) {
        String newContactInfo = ui.inputNewContactInfo();
        manager.editContactInfo(user, newContactInfo);
    }

    /**
     * Edits user's program of study.
     * 
     * @param user  A user whose program of study to be edited
     */
    private void editProgramOfStudy(User user) {
        String newProgramOfStudy = ui.inputNewProgramOfStudy();
        manager.editProgramOfStudy(user, newProgramOfStudy);
    }

    /**
     * Edits user's username.
     * 
     * @param user A user whose username is to be edited
     */
    private void editUserName(User user) {
        String newName = ui.inputNewName();
        manager.editName(user, newName);
    }

    /**
     * Runs the login functionality.
     */
    private void login() {
        String id = ui.runLogin();
        User user = manager.getUserById(id);
        // the requested user doesn't exist
        if (user == null) {
            // not doing anything yet
        }
        else {
            edit(user);
        }
    }

    /**
     * Runs the register functionality.
     */
    private void register() {
        String[] inputs = ui.runRegister();
        ui.runRegisterSuccess(manager.createUser(inputs, true));
    }

    /**
     * Runs the matching algorithm.
     */
    public void doMatching() {
        ArrayList<User> users = new ArrayList<User>(this.manager.getUsers().values());
        Matcher matcher = new Matcher();
        Map<String, List<Match>> matchResults = matcher.match(users);
        this.manager.modifyCurrentMatches(matchResults);
    }
}
