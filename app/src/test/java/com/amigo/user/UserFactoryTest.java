package com.amigo.user;
import static org.junit.Assert.*;

import com.amigo.course.Course;
import com.amigo.course.CourseSetFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class UserFactoryTest {
    private Profile profile1;
    private UserFactory userFactory;

    @Before
    public void setUp() {
        userFactory = new UserFactory();
        Course course1 = new Course("CSC207", "LEC0101", "TUT0501");
        Course course2 = new Course("CSC263", "LEC0201", "TUT0301");
        HashSet<Course> courseList = new HashSet<>(Arrays.asList(course1, course2));
        profile1 = new Profile("Maeve", 3, "Political Science", courseList,
                "maeve@gmail.com");
    }

    @Test(timeout = 100)
    public void testCreateUser(){
        User user1 = userFactory.createUser(profile1);

        assertNotNull(user1.getId());
        assertEquals(user1.getProfile(), profile1);
    }
}
