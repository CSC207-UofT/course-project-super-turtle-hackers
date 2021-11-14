package com.amigo.course;

/**
 * A course that the user is taking.
 */
public class Course {
    private String courseCode;
    private String lecture;
    private String tutorial;

    /**
     * Creates a course with only the courseCode
     */
    public Course(String courseCode) {
        this(courseCode, "", "");
    }

    public Course(String courseCode, String lecture, String tutorial) {
        this.courseCode = courseCode;
        this.lecture = lecture;
        this.tutorial = tutorial;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getLecture() {
        return lecture;
    }

    public String getTutorial() {
        return tutorial;
    }

    /**
     * Returns a String representation of the course readable by MySQL.
     */
    public String toString() {
        return "Course{" + courseCode + ", "
                + lecture + ", "
                + tutorial;
    }
}
