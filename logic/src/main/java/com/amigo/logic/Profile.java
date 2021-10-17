package com.amigo.logic;

import java.util.HashSet;

public class Profile {
    private String name;
    private int yearOfStudy;
    private String programOfStudy;
    private HashSet<Course> courses;
    private String contactInfo;

    public Profile(String name, int yearOfStudy, String programOfStudy, HashSet<Course> courses,
                   String contactInfo) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
        this.programOfStudy = programOfStudy;
        this.courses = courses;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getProgramOfStudy() {
        return programOfStudy;
    }

    public void setProgramOfStudy(String programOfStudy) {
        this.programOfStudy = programOfStudy;
    }

    public HashSet<Course> getCourses() {
        return courses;
    }

    public void setCourses(HashSet<Course> courses) {
        this.courses = courses;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
