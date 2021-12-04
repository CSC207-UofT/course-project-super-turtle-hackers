package com.amigo.user;
import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import com.amigo.course.Course;
import com.amigo.match.Match;

public class UserTest {
    @Before
    public void setUp() {
    }

    @Test(timeout = 100)
    public void userTest() {
        Course course1 = new Course("CSC207", "LEC0101", "TUT0501");
        Course course2 = new Course("CSC263", "LEC0201", "TUT0301");
        Course course3 = new Course("STA247", "LEC0201", "TUT0301");
        Course course4 = new Course("WGS275", "LEC0101", "TUT0101");
        HashSet<Course> profile1courses = new HashSet<Course>(Arrays.asList(course1, course2));
        HashSet<Course> profile2courses = new HashSet<Course>(Arrays.asList(course2, course3));
        HashSet<Course> profile3courses = new HashSet<Course>(Collections.singletonList(course4));
        HashSet<Course> profile4courses = new HashSet<Course>(Collections.singletonList(course1));
        //hobbies, music, sport, rec
        Profile profile1 = new Profile("Dien", 2, "Computer Science",
                profile1courses, "dien@mail.utoronto.ca", "Art", "Volleyball",
                "Justin Bieber", "Sleep");
        Profile profile2 = new Profile("Akshat", 2, "Computer Science",
                profile2courses, "akshat@mail.utoronto.ca", "Hackathons", "Rock Climbing", "Greenday", "Jazz");
        Profile profile3 = new Profile("Tony", 1, "Women and Gender Studies",
                profile3courses, "iloveponies@gmail.com", "", "Skating", "", "");
        Profile profile4 = new Profile("Sriracha", 3, "Pathobiology",
                profile4courses, "hotsauceisthesauce@yahoo.co.in", "", "", "", "");
        User user1 = new User(profile1, "dien001", "dien@mail.utoronto.ca", "password1");
        User user2 = new User(profile2, "aksh002", "akshat@mail.utoronto.ca", "rockclimbingislove");
        User user3 = new User(profile3, "tony003", "iloveponies@gmail.com", "ponieslove");
        User user4 = new User(profile4, "srir004", "hotsauceisthesauce@yahoo.co.in", "hotsauceislove");

        assertEquals(user1.getId(), "dien001");
        assertEquals(user2.getId(), "aksh002");
        assertEquals(user3.getId(), "tony003");
        assertEquals(user4.getId(), "srir004");

        assertEquals(user1.getProfile(), profile1);
        assertEquals(user2.getProfile(), profile2);
        assertEquals(user3.getProfile(), profile3);
        assertEquals(user4.getProfile(), profile4);

        ArrayList <Match> user1_current_matches = new ArrayList<Match>();
        ArrayList <Match> user2_current_matches = new ArrayList<Match>();
        ArrayList <Match> user3_current_matches = new ArrayList<Match>();
        ArrayList <Match> user4_current_matches = new ArrayList<Match>();
        Match match1 = new Match(user1, user2, new Date(), 1.0/3.0);
        Match match2 = new Match(user1, user3, new Date(), 2.0/3.0);
        Match match3 = new Match(user3, user4, new Date(), 1.5/3.0);
        user1_current_matches.add(match1);
        user1_current_matches.add(match2);
        user2_current_matches.add(match1);
        user3_current_matches.add(match2);
        user3_current_matches.add(match3);
        user4_current_matches.add(match3);
        user1.setCurrentMatches(user1_current_matches);
        user2.setCurrentMatches(user2_current_matches);
        user3.setCurrentMatches(user3_current_matches);
        user4.setCurrentMatches(user4_current_matches);

        assertEquals(user1_current_matches, user1.getCurrentMatches());
        assertEquals(user2_current_matches, user2.getCurrentMatches());
        assertEquals(user3_current_matches, user3.getCurrentMatches());
        assertEquals(user4_current_matches, user4.getCurrentMatches());
        
        assertEquals(user1.toStringCurrentMatches(), "[Akshat, Tony]");
        assertEquals(user2.toStringCurrentMatches(), "[Dien]");
        assertEquals(user3.toStringCurrentMatches(), "[Dien, Sriracha]");
        assertEquals(user4.toStringCurrentMatches(), "[Tony]");
    }
}
