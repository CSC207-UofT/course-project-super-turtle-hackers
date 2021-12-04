package com.amigo.user;


import com.amigo.course.Course;

import java.util.HashSet;

public class ProfileFactory{

    /**
     * Constructor for ProfileFactory
     */
    public ProfileFactory() {
    }

    /**
     * Creates a Profile object to be injected into a User object.
     * @param name the name of the user
     * @param yearOfStudy the yearOfStudy of the user
     * @param programOfStudy the programOfStudy of the user
     * @param courses a set of courses the user is taking
     * @param contactInfo the contact information of the user
     * @return a new Profile object that stores all the information
     */
    public Profile createProfile(String name, int yearOfStudy, String programOfStudy, HashSet<Course> courses,
                                 String contactInfo, String hobbies, String sportInterest, String musInterest, String recInterest) {
        return new Profile(name, yearOfStudy, programOfStudy, courses, contactInfo, hobbies,
                sportInterest, musInterest, recInterest);
    }
}
