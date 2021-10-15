package com.amigo.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserManager {

    private Map<String, User> users;

    public UserManager(UserDatabase database) {
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
}
