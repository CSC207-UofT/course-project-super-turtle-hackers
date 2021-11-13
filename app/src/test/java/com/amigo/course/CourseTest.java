package com.amigo.course;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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


        assertEquals("CSC207", course1.getCourseCode());
        assertEquals("CSC263", course2.getCourseCode());
        assertEquals("STA247", course3.getCourseCode());
        assertEquals("WGS275", course4.getCourseCode());

        assertEquals("LEC0101", course1.getLecture());
        assertEquals("LEC0201", course2.getLecture());
        assertEquals("LEC0201", course3.getLecture());
        assertEquals("LEC0101", course4.getLecture());

        assertEquals("TUT0501", course1.getTutorial());
        assertEquals("TUT0301", course2.getTutorial());
        assertEquals("TUT0301", course3.getTutorial());
        assertEquals("TUT0101", course4.getTutorial());


    }
}
