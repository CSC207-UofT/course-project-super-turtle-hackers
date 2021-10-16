package com.amigo.logic;

import com.amigo.logic.ui.TUI;

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
}
