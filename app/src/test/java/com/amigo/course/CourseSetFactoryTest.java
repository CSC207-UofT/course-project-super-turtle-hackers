package com.amigo.course;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class CourseSetFactoryTest {
    private CourseSetFactory courseSetFactory;

    @Before
    public void setUp() {
        courseSetFactory = new CourseSetFactory();
    }

    @Test(timeout = 100)
    public void testCreateCourseSet() {

        HashSet<Course> courseSet1 = courseSetFactory.createCourseSet("CSC207,CSC236,COG250");
        HashSet<Course> courseSet2 = courseSetFactory.createCourseSet("CSC148");
        HashSet<Course> courseSet3 = courseSetFactory.createCourseSet("CSC207,CSC236,COG250");
        HashSet<Course> courseSet4 = courseSetFactory.createCourseSet("");
        Course course1 = new Course("CSC207");
        Course course2 = new Course("MAT334");
        Course course3 = new Course("CHM222");

        assertEquals(3, courseSet1.size());
        assertEquals(1, courseSet2.size());
        assertFalse(courseSet4.isEmpty());

        courseSet4.add(course3);
        courseSet2.add(course1);
        courseSet1.remove(course1);

        assertTrue(courseSet4.contains(course3));
        assertTrue(courseSet2.contains(course1));
        assertFalse(courseSet1.contains(course1));

    }
}