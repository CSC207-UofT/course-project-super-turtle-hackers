package com.amigo.course;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A course that the user is taking.
 */
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
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

    /**
     * Returns the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Returns the lecture section
     */
    public String getLecture() {
        return lecture;
    }

    /**
     * Returns the tutorial section
     */
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
