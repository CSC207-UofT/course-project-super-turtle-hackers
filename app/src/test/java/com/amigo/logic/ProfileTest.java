package com.amigo.logic;

import org.junit.*;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class ProfileTest {
    private Profile newProfile;
    private HashSet<Course> courseList;
    private Course course1;
    private Course course2;

    @Before
    public void setUp() {
        course1 = new Course("CSC207", "LEC0101", "TUT0501");
        course2 = new Course("CSC263", "LEC0201", "TUT0301");
        courseList = new HashSet<>(Arrays.asList(course1, course2));
        newProfile = new Profile("Maeve", 3, "Political Science", courseList,
                "maeve@gmail.com");
    }

    @After
    public void tearDown() {
        Course course1 = new Course("CSC207", "LEC0101", "TUT0501");
        Course course2 = new Course("CSC263", "LEC0201", "TUT0301");
        courseList = new HashSet<>(Arrays.asList(course1, course2));
        newProfile = new Profile("Maeve", 3, "Political Science", courseList,
                "maeve@gmail.com");
    }

    @Test(timeout = 100)
    public void testGetName() {
        assertEquals(newProfile.getName(), "Maeve");
    }

    @Test(timeout = 100)
    public void testGetCourses() {
        HashSet<Course> courseList = new HashSet<>(Arrays.asList(course1, course2));
        assertEquals(newProfile.getCourses(), courseList);
    }

    @Test(timeout = 100)
    public void testGetProgramOfStudy() {
        assertEquals(newProfile.getProgramOfStudy(), "Political Science");
    }

    @Test(timeout = 100)
    public void testGetYearOfStudy() {
        assertEquals(newProfile.getYearOfStudy(), 3);
    }

    @Test(timeout = 100)
    public void testGetContactInfo() {
        assertEquals(newProfile.getContactInfo(), "maeve@gmail.com");
    }

    @Test(timeout = 100)
    public void testSetName() {
        newProfile.setName("Patrick");
        assertEquals(newProfile.getName(), "Patrick");
    }

    @Test(timeout = 100)
    public void testAddCourses() {
        Course course3 = new Course("MAT237");
        newProfile.addCourses(course3);
        assertEquals(newProfile.getCourses().size(), 3);
    }

    @Test(timeout = 100)
    public void testSetProgramOfStudy() {
        newProfile.setProgramOfStudy("Anthropology");
        assertEquals(newProfile.getProgramOfStudy(), "Anthropology");
    }

    @Test (timeout = 100)
    public void testSetContactInfo() {
        newProfile.setContactInfo("@maeve123");
        assertEquals(newProfile.getContactInfo(), "@maeve123");
    }
}
