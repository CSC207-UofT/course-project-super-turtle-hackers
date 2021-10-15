package com.amigo.logic;

import java.util.ArrayList;

public class Profile {
    private String name;
    private int yearOfStudy;
    private String programOfStudy;
    private ArrayList<Course> courses;
    private String contactInfo;

    public Profile(String name, int yearofstudy, String programofstudy, ArrayList<Course> courses,
                   String contactinfo) {
        this.name = name;
        this.yearOfStudy = yearofstudy;
        this.programOfStudy = programofstudy;
        this.courses = courses;
        this.contactInfo = contactinfo;
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

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
