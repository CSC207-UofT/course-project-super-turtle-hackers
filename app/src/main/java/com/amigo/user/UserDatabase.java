package com.amigo.user;

import java.util.List;

public interface UserDatabase {
    public List<User> getUsers();

    /**
     * Adds a user to the database
     *
     * @return if the user was successfully added
     */
    public boolean addUser(User user);
}
