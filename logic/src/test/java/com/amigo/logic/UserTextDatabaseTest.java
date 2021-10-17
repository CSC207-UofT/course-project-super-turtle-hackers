package com.amigo.logic;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;


public class UserTextDatabaseTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    @Test(timeout = 100)
    public void testGetUsers() {
        UserTextDatabase userTextDatabase = new UserTextDatabase();
        List<User> listOfUsers = userTextDatabase.getUsers();
        assertEquals(listOfUsers.size(), 9);
        assertEquals(listOfUsers.get(0).getProfile().getName(), "Akshat Naik");
        assertEquals(listOfUsers.get(1).getProfile().getName(), "Dien Nguyen");
        assertEquals(listOfUsers.get(2).getProfile().getName(), "Adrian Tai");
        assertEquals(listOfUsers.get(3).getProfile().getName(), "Rue Sriharsha");
        assertEquals(listOfUsers.get(4).getProfile().getName(), "Tony Hu");
        assertEquals(listOfUsers.get(5).getProfile().getName(), "Lawrence Tsai");
        assertEquals(listOfUsers.get(6).getProfile().getName(), "Miley Cyrus");
        assertEquals(listOfUsers.get(7).getProfile().getName(), "Donald Trump");
        assertEquals(listOfUsers.get(8).getProfile().getName(), "Susan Cao");
    }

}


