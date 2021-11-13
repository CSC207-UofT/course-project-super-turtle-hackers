package com.amigo.match;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import com.amigo.course.Course;
import com.amigo.user.User;
import com.amigo.user.Profile;

public class MatcherTest {
    @Before
    public void setUp() {
    }

    @Test(timeout = 100)
    public void testMatching() {
        Course course1 = new Course("CSC207", "LEC0101", "TUT0501");
        Course course2 = new Course("CSC263", "LEC0201", "TUT0301");
        Course course3 = new Course("STA247", "LEC0201", "TUT0301");
        Course course4 = new Course("WGS275", "LEC0101", "TUT0101");
        HashSet<Course> profile1courses = new HashSet<Course>(Arrays.asList(course1, course2));
        HashSet<Course> profile2courses = new HashSet<Course>(Arrays.asList(course2, course3));
        HashSet<Course> profile3courses = new HashSet<Course>(Collections.singletonList(course4));
        HashSet<Course> profile4courses = new HashSet<Course>(Collections.singletonList(course1));
        Profile profile1 = new Profile("Dien", 2, "Computer Science",
                profile1courses, "dien@mail.utoronto.ca");
        Profile profile2 = new Profile("Akshat", 2, "Computer Science",
                profile2courses, "akshat@mail.utoronto.ca");
        Profile profile3 = new Profile("Tony", 1, "Women and Gender Studies",
                profile3courses, "iloveponies@gmail.com");
        Profile profile4 = new Profile("Sriracha", 3, "Pathobiology",
                profile4courses, "hotsauceisthesauce@yahoo.co.in");
        User user1 = new User(profile1, "dien001");
        User user2 = new User(profile2, "aksh002");
        User user3 = new User(profile3, "tony003");
        User user4 = new User(profile4, "srir004");

        ArrayList<User> listOfUsers = new ArrayList<User>(Arrays.asList(user1, user2, user3, user4));

        Matcher matcher = new Matcher();
        HashMap<String, ArrayList<Match>> matchingResults = matcher.matching(listOfUsers);
        assertEquals(matchingResults.get("dien001").size(), 2);
        assertEquals(matchingResults.get("aksh002").size(), 1);
        assertEquals(matchingResults.get("tony003").size(), 0);
        assertEquals(matchingResults.get("srir004").size(), 1);
    }
}
