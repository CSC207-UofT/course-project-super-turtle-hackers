package com.amigo.match;

import static org.junit.Assert.assertEquals;

import java.util.*;

import com.amigo.course.Course;
import com.amigo.user.Profile;
import com.amigo.user.User;

import org.junit.Before;
import org.junit.Test;

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
        Course course5 = new Course("MAT354", "LEC0201", "TUT0201");
        HashSet<Course> profile1courses = new HashSet<Course>(Arrays.asList(course1, course2));
        HashSet<Course> profile2courses = new HashSet<Course>(Arrays.asList(course2, course3));
        HashSet<Course> profile3courses = new HashSet<Course>(Collections.singletonList(course4));
        HashSet<Course> profile4courses = new HashSet<Course>(Collections.singletonList(course1));
        HashSet<Course> profile5courses = new HashSet<Course>(Collections.singletonList(course5));
        Profile profile1 = new Profile("Dien", 2, "Computer Science",
                profile1courses, "dien@mail.utoronto.ca");
        Profile profile2 = new Profile("Akshat", 2, "Computer Science",
                profile2courses, "akshat@mail.utoronto.ca");
        Profile profile3 = new Profile("Tony", 1, "Women and Gender Studies",
                profile3courses, "iloveponies@gmail.com");
        Profile profile4 = new Profile("Sriracha", 3, "Pathobiology",
                profile4courses, "hotsauceisthesauce@yahoo.co.in");
        Profile profile5 = new Profile("Larry", 4, "Mathematics",
                profile5courses, "l.tsai@mail.utoronto.ca");

        User user1 = new User(profile1, "dien001");
        User user2 = new User(profile2, "aksh002");
        User user3 = new User(profile3, "tony003");
        User user4 = new User(profile4, "srir004");
        User user5 = new User(profile5, "larr005");

        ArrayList<User> listOfUsers = new ArrayList<User>(Arrays.asList(user1, user2, user3, user4, user5));

        Matcher matcher = new Matcher();

        Map<String, List<Match>> matchingResults = matcher.match(listOfUsers);
        assertEquals(2, matchingResults.get("dien001").size());
        assertEquals(1, matchingResults.get("aksh002").size());
        assertEquals(0, matchingResults.get("tony003").size());
        assertEquals(1, matchingResults.get("srir004").size());
        assertEquals(3, matcher.metric(user1, user2));
        assertEquals(0, matcher.metric(user2, user3));
        assertEquals(-1, matcher.metric(user3, user5));

    }
}