package com.amigo.course;

import java.util.HashSet;

public class CourseSetFactory {
    /**
     * Constructor for CourseSetFactory
     */
    public CourseSetFactory() {
    }

    /**
     * Creates a course set using a string of course codes
     * @param stringOfCourseCodes a string containing course codes, each separated by commas
     * @return a new HashSet containing a user's courses
     */
    public HashSet<Course> createCourseSet(String stringOfCourseCodes) {
        String[] courseStrings = stringOfCourseCodes.split(",");
        HashSet<Course> courseSet = new HashSet<>();
        for (String c : courseStrings) {
            courseSet.add(new Course(c));
        }
        return courseSet;
    }
}
