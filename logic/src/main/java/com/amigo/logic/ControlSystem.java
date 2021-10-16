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
        // TODO: Input users
//        String response = ui.runWelcome();
//        if (response.equals("y")) {
//            login();
//        }
//        else {
//            register();
//        }
        this.doMatching();
        ArrayList<User> users =  new ArrayList<User>(this.manager.getUsers().values());
        for (User user: users) {
            Profile profile = user.getProfile();
            System.out.println(profile.getName() + ": " + user.toStringCurrentMatches());
        }

    }

    private void login() {
        String id = ui.runLogin();
        User user = manager.getUserById(id);
        // the requested user doesn't exist
        if (user == null) {
            // not doing anything yet
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
