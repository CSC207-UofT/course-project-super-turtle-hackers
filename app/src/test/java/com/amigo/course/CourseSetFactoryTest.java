package com.amigo.course;
import static org.junit.Assert.assertEquals;

import com.amigo.user.*;
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
        HashSet<Course> courseSet3 = courseSetFactory.createCourseSet("");

        Set<Course> expectedSet1 = new HashSet<>();
        Course course1 = new Course("CSC207");
        expectedSet1.add(course1);
        Course course2 = new Course("CSC236");
        expectedSet1.add(course2);
        Course course3 = new Course("COG250");
        expectedSet1.add(course3);

        assertEquals(expectedSet1, courseSet1);

        Set<Course> expectedSet2 = new HashSet<>();
        Course course4 = new Course("CSC148");
        expectedSet2.add(course4);

        assertEquals(expectedSet2, courseSet2);

        Set<Course> expectedSet3 = new HashSet<>();
        assertEquals(expectedSet3, courseSet3);

    }
}

