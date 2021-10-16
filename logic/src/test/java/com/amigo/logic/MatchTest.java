package com.amigo.logic;

import org.junit.*;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;


public class MatchTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 100)
    public void testHaveSameCourse() {
        // Create courses
        Course course1 = new Course("CSC207", "LEC0101", "TUT0501");
        Course course2 = new Course("CSC263", "LEC0201", "TUT0301");
        Course course3 = new Course("STA247", "LEC0201", "TUT0301");
        // Create a set that contains the courses that a user is taking
        HashSet<Course> profile1courses = new HashSet<Course>(Arrays.asList(course1, course2));
        HashSet<Course> profile2courses = new HashSet<Course>(Arrays.asList(course2, course3));
        // Create profile for users
        Profile profile1 = new Profile("Dien", 2, "Computer Science",
                profile1courses, "dien@mail.utoronto.ca");
        Profile profile2 = new Profile("Akshat", 2, "Computer Science",
                profile2courses, "akshat@mail.utoronto.ca");
        // Link user to profile
        User user1 = new User(profile1, "dien001");
        User user2 = new User(profile2, "aksh002");
        // Manually match users
        Match match1 = new Match(user1, user2, LocalDateTime.now());
        // Check if they have a course in common
        HashSet<Course> user1courses = new HashSet<>(match1.getUser1().getProfile().getCourses());
        HashSet<Course> user2courses = new HashSet<>(match1.getUser2().getProfile().getCourses());
        user1courses.retainAll(user2courses);
        assertEquals(user1courses.size(),1);
    }
}