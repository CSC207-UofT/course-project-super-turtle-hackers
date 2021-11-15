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

        assertEquals(3, courseSet1.size());
        assertEquals(1, courseSet2.size());
        //TODO: add more testing

    }
}