package com.amigo.logic;
import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class CourseTest {
    @Before
    public void setUp() {
    }

    @Test(timeout = 100)
    public void testCourses() {
        Course course1 = new Course("CSC207", "LEC0101", "TUT0501");
        Course course2 = new Course("CSC263", "LEC0201", "TUT0301");
        Course course3 = new Course("STA247", "LEC0201", "TUT0301");
        Course course4 = new Course("WGS275", "LEC0101", "TUT0101");


        assertEquals(course1.getCourseCode(), "CSC207");
        assertEquals(course2.getCourseCode(), "CSC263");
        assertEquals(course3.getCourseCode(), "STA247");
        assertEquals(course4.getCourseCode(), "WGS275");

        assertEquals(course1.getLecture(), "LEC0101");
        assertEquals(course2.getLecture(), "LEC0201");
        assertEquals(course3.getLecture(), "LEC0201");
        assertEquals(course4.getLecture(), "LEC0101");

        assertEquals(course1.getTutorial(), "TUT0501");
        assertEquals(course2.getTutorial(), "TUT0301");
        assertEquals(course3.getTutorial(), "TUT0301");
        assertEquals(course4.getTutorial(), "TUT0101");


    }
}
