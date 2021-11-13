package com.amigo.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;

public class UserManagerTest {

    @Before
    public void setUp() {
    }

    @Test (timeout = 100)
    public void testGetUserById() {
        UserDatabase db = new UserTextDatabase();
        UserManager manager = new UserManager(db);
        List<User> listOfUsers = db.getUsers();
        String firstUserId = listOfUsers.get(0).getId();
        String middleUserId = listOfUsers.get((listOfUsers.size() / 2)).getId();
        String lastUserId = listOfUsers.get((listOfUsers.size()) - 1).getId();
        User firstUser = manager.getUserById(firstUserId);
        User middleUser = manager.getUserById(middleUserId);
        User lastUser = manager.getUserById(lastUserId);
        assertEquals("Akshat Naik", firstUser.getProfile().getName());
        assertEquals("Tony Hu", middleUser.getProfile().getName());
        assertEquals( "Susan Cao", lastUser.getProfile().getName());
    }

    @Test (timeout = 100)
    public void testGetUsers() {
        UserDatabase db = new UserTextDatabase();
        UserManager manager = new UserManager(db);
        List<User> listOfUsers = db.getUsers();
        Map<String, User> allUsers = manager.getUsers();
        for (User user : listOfUsers) {
            assertEquals(allUsers.size(), 9);
        }
        for (User user : allUsers.values()) {
            boolean hasUser = false;
            for (User user2 : listOfUsers) {
                if (Objects.equals(user.getProfile().getName(), user2.getProfile().getName())) {
                    hasUser = true;
                }
                assertTrue(String.valueOf(hasUser), true);
            }
        }
    }

    @Test (timeout = 100)
    public void testCreateUser() {

    }
}
