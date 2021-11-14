package com.amigo.course;

public class Course {
    private String courseCode;
    private String lecture;
    private String tutorial;

    public String getCourseCode() {
        return courseCode;
    }

    public String getLecture() {
        return lecture;
    }

    public String getTutorial() {
        return tutorial;
    }

    public Course(String courseCode) {
        this(courseCode, "", "");
    }

    public Course(String courseCode, String lecture, String tutorial) {
        this.courseCode = courseCode;
        this.lecture = lecture;
        this.tutorial = tutorial;
    }

    public String toString() {
        return "Course{" + courseCode + ", "
                + lecture + ", "
                + tutorial;
    }
}
