package com.amigo.user;

import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.Entity;
import com.amigo.course.Course;

/**
 * A profile containing a name, year of study, program of study, courses and contact info.
 */
@Entity
public class Profile {
    private String name;
    private int yearOfStudy;
    private String programOfStudy;
    private HashSet<Course> courses;
    private String contactInfo;

    /**
     * Creates a profile containing a name, year of study, program of study, courses and contact info.
     */
    public Profile(String name, int yearOfStudy, String programOfStudy, HashSet<Course> courses,
                   String contactInfo) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.programOfStudy = programOfStudy;
        this.courses = courses;
        this.contactInfo = contactInfo;
    }

    /**
     * Returns the profile name
     */
    public String getName() {
        return name;
    }

    /**
     * Creates a profile name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the profile's year of study
     */
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    /**
     * Creates a profile's year of study
     */
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * Returns the profile's program of study
     */
    public String getProgramOfStudy() {
        return programOfStudy;
    }

    /**
     * Creates a profile's program of study
     */
    public void setProgramOfStudy(String programOfStudy) {
        this.programOfStudy = programOfStudy;
    }

    /**
     * Returns the profile's courses
     */
    public HashSet<Course> getCourses() {
        return courses;
    }

    /**
     * Returns a list of strings of the profile's courses
     */
    public ArrayList<String> getCoursesList() {
        ArrayList<String> coursesStringList = new ArrayList<>();
        for (Course course : courses) {
            coursesStringList.add(course.toString());
        }
        return coursesStringList;
    }

    /**
     * Returns the profile's contact info
     */
    public String getContactInfo() {
        return contactInfo;
    }

    /**
     * Creates a profile's contact info
     */
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    /**
     * Adds a course to the courses a profile has
     */
    public void addCourses(Course course) {
        this.courses.add(course);
    }
}
