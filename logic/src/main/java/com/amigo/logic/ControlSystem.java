package com.amigo.logic;

import com.amigo.logic.ui.TUI;

import java.util.ArrayList;
import java.util.HashMap;

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
        ArrayList<User> users =  new ArrayList<User>(this.manager.getUsers().values());
        for (User user: users) {
            Profile profile = user.getProfile();
            System.out.println(profile.getName() + ": " + user.toStringCurrentMatches());
        }

    }

    private void edit(User user) {
        String response = ui.runEdit();
        if (response.equals("y")) {
            String editItem = ui.chooseEdit();
            if (editItem.equals("1")) {
                editUserName(user);
            } else if (editItem.equals("2")) {
                editProgramOfStudy(user);
            } else if (editItem.equals("4")) {
                editContactInfo(user);
            } else {
                editCourses(user);
            }
        }
    }

    private void editCourses(User user) {
        String addOrRemoveCourse = ui.inputAddOrRemoveCourse();
        if (addOrRemoveCourse.equals("1")) {
            String newCourseCode = ui.inputNewCourse();
            manager.addCourses(user, new Course(newCourseCode));
        } else {
            String removeCourseCode = ui.inputRemoveCourse();
            manager.removeCourses(user, removeCourseCode);
        }
    }

    private void editContactInfo(User user) {
        String newContactInfo = ui.inputNewContactInfo();
        manager.editContactInfo(user, newContactInfo);
    }

    private void editProgramOfStudy(User user) {
        String newProgramOfStudy = ui.inputNewProgramOfStudy();
        manager.editProgramOfStudy(user, newProgramOfStudy);
    }

    private void editUserName(User user) {
        String newName = ui.inputNewName();
        manager.editName(user, newName);
    }

    private void login() {
        String id = ui.runLogin();
        User user = manager.getUserById(id);
        // the requested user doesn't exist
        if (user == null) {
            // not doing anything yet
        } else {
            edit(user);
        }
    }

    private void register() {
        String[] inputs = ui.runRegister();
        ui.runRegisterSuccess(manager.createUser(inputs, true));
    }

    public void doMatching() {
        ArrayList<User> users =  new ArrayList<User>(this.manager.getUsers().values());
        Matcher matcher = new Matcher();
        HashMap<String, ArrayList<Match>> matchResults = matcher.matching(users);
        this.manager.modifyCurrentMatches(matchResults);
    }
}
