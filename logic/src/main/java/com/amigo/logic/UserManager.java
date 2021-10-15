package com.amigo.logic;

import java.io.FileNotFoundException;
import java.util.List;

public class UserManager {

    private List<User> users;

    public UserManager(UserDatabase database) throws FileNotFoundException {
        users = database.getUsers();
    }

    public List<User> getUsers() {
        return users;
    }
}
