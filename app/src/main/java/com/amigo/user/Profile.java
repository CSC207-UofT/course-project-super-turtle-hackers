package com.amigo.user;

import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.Entity;
import com.amigo.course.Course;

/**
 * A profile containing a name, year of study, program of study, courses, contact info and interests.
 */
@Entity
public class Profile {
    private String name;
    private int yearOfStudy;
    private String programOfStudy;
    private HashSet<Course> courses;
    private String contactInfo;
    private String recInterest;
    private String musInterest;
    private String sportInterest;
    private String hobbies;

    /**
     * Creates a profile using the default constructor
     */
    public Profile() {
        this.courses = new HashSet<>();
    }
    
    /**
     * Creates a profile containing a name, year of study, program of study, courses, contact info and interests.
     */
    public Profile(String name, int yearOfStudy, String programOfStudy, HashSet<Course> courses,
                   String contactInfo, String hobbies, String sportInterest, String musInterest, String recInterest) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.programOfStudy = programOfStudy;
        this.courses = courses;
        this.contactInfo = contactInfo;
        this.hobbies = hobbies;
        this.sportInterest = sportInterest;
        this.musInterest = musInterest;
        this.recInterest = recInterest;
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

    public String getCoursesAsString() {
        return getCoursesList().toString();
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
     * Returns the profile's hobbies
     */
    public String getHobbies() {
        return hobbies;
    }

    /**
     * Creates a profile's hobbies
     */
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    /**
     * Returns the profile's music interests
     */
    public String getMusInterest() {
        return musInterest;
    }

    /**
     * Creates a profile's music interests
     */
    public void setMusInterest(String musInterest) {
        this.musInterest = musInterest;
    }

    /**
     * Returns the profile's recreational interests
     */
    public String getRecInterest() {
        return recInterest;
    }

    /**
     * Creates a profile's recreational interests
     */
    public void setRecInterest(String recInterest) {
        this.recInterest = recInterest;
    }

    /**
     * Returns the profile's sport interests
     */
    public String getSportInterest() {
        return sportInterest;
    }

    /**
     * Creates a profile's sport interests
     */
    public void setSportInterest(String sportInterest) {
        this.sportInterest = sportInterest;
    }

    /**
     * Adds a course to the courses a profile has
     */
    public void addCourses(Course course) {
        this.courses.add(course);
    }
}
