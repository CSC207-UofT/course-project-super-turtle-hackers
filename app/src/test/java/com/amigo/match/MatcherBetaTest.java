package com.amigo.match;

import static org.junit.Assert.assertEquals;

import java.util.*;

import com.amigo.course.Course;
import com.amigo.user.Profile;
import com.amigo.user.User;

import org.junit.Before;
import org.junit.Test;

public class MatcherBetaTest {
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
        Course course6 = new Course("MAT133", "LEC0101", "TUT0401");
        Course course7 = new Course("MAT137", "LEC0301", "TUT0401");

        HashSet<Course> profile1courses = new HashSet<>(Arrays.asList(course1, course2));
        HashSet<Course> profile2courses = new HashSet<>(Arrays.asList(course2, course3));
        HashSet<Course> profile3courses = new HashSet<>(Collections.singletonList(course4));
        HashSet<Course> profile4courses = new HashSet<>(Collections.singletonList(course1));
        HashSet<Course> profile5courses = new HashSet<>(Collections.singletonList(course5));
        HashSet<Course> profile6courses = new HashSet<>(Collections.singletonList(course6));
        HashSet<Course> profile7courses = new HashSet<>(Collections.singletonList(course7));

        Profile profile1 = new Profile("Dien", 2, "Computer Science",
                profile1courses, "dien@mail.utoronto.ca", "", "", "", "");
        Profile profile2 = new Profile("Akshat", 2, "Computer Science",
                profile2courses, "akshat@mail.utoronto.ca", "", "", "", "");
        Profile profile3 = new Profile("Tony", 1, "Women and Gender Studies",
                profile3courses, "iloveponies@gmail.com", "", "", "", "");
        Profile profile4 = new Profile("Sriracha", 3, "Pathobiology",
                profile4courses, "hotsauceisthesauce@yahoo.co.in", "", "", "", "");
        Profile profile5 = new Profile("Larry", 4, "Mathematics",
                profile5courses, "l.tsai@mail.utoronto.ca", "", "", "", "");
        Profile profile6 = new Profile("Joe", 3, "Math",
                profile6courses, "joe@mail.utoronto.ca", "", "", "", "");
        Profile profile7 = new Profile("Bob", 2, "Mathe",
                profile7courses, "bob@mail.utoronto.ca", "", "", "", "");

        User user1 = new User(profile1, "dien001", "", "");
        User user2 = new User(profile2, "aksh002", "", "");
        User user3 = new User(profile3, "tony003", "", "");
        User user4 = new User(profile4, "srir004", "", "");
        User user5 = new User(profile5, "larr005", "", "");
        User user6 = new User(profile6, "joee006", "", "");
        User user7 = new User(profile7, "bobb007", "", "");

        ArrayList<User> listOfUsers = new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5, user6, user7));

        MatcherBeta matcher = new MatcherBeta();

        Map<String, List<Match>> matchingResults = matcher.match(listOfUsers);

        assertEquals(4, matchingResults.get("dien001").size());
        assertEquals(3, matchingResults.get("aksh002").size());
        assertEquals(2, matchingResults.get("tony003").size());
        assertEquals(3, matchingResults.get("srir004").size());
        assertEquals(2, matchingResults.get("larr005").size());
        assertEquals(2, matchingResults.get("joee006").size());
        assertEquals(2, matchingResults.get("bobb007").size());

        assertEquals(2.5, matcher.metric(user1, user2), 0.1);
        assertEquals(1, matcher.metric(user2, user3),0.1);
        assertEquals(0, matcher.metric(user3, user5),0.1);
        assertEquals(1, matcher.metric(user5, user6),0.1);
        assertEquals(1, matcher.metric(user6, user7),0.1);
        assertEquals(0, matcher.metric(user5, user7),0.1);

    }
}