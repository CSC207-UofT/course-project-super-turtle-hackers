package com.amigo.course;

import java.util.HashSet;

public class CourseSetFactory {

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

    /**
     * Check if two coursesets are equal
     */

    public boolean equals (HashSet<Course> CourseSet1, HashSet<Course> CourseSet2 ){
        for (Course c : CourseSet1) {
            for (Course d : CourseSet2) {
                if (d != c){
                    return false;
                }
            }
        }
        return true;
    }
}
