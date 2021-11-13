package com.amigo.user;

import org.junit.*;

import java.util.Arrays;
import java.util.HashSet;
import com.amigo.course.Course;

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
        assertEquals(courseList, newProfile.getCourses());
    }

    @Test(timeout = 100)
    public void testGetProgramOfStudy() {
        assertEquals("Political Science", newProfile.getProgramOfStudy());
    }

    @Test(timeout = 100)
    public void testGetYearOfStudy() {
        assertEquals(3, newProfile.getYearOfStudy());
    }

    @Test(timeout = 100)
    public void testGetContactInfo() {
        assertEquals("maeve@gmail.com", newProfile.getContactInfo());
    }

    @Test(timeout = 100)
    public void testSetName() {
        newProfile.setName("Patrick");
        assertEquals("Patrick", newProfile.getName());
    }

    @Test(timeout = 100)
    public void testAddCourses() {
        Course course3 = new Course("MAT237");
        newProfile.addCourses(course3);
        assertEquals( 3, newProfile.getCourses().size());
    }

    @Test(timeout = 100)
    public void testSetProgramOfStudy() {
        newProfile.setProgramOfStudy("Anthropology");
        assertEquals("Anthropology", newProfile.getProgramOfStudy());
    }

    @Test (timeout = 100)
    public void testSetContactInfo() {
        newProfile.setContactInfo("@maeve123");
        assertEquals("@maeve123", newProfile.getContactInfo());
    }
}
