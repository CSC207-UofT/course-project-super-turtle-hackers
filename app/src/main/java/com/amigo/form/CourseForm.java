package com.amigo.form;
/**
 * Input course to be inputted for a given user
 */
public class CourseForm {

    private String courseCode;
    private String lectureCode;
    private String tutorialCode;
    /**
     * Returns the course code
     */
    public String getCourseCode() {
        return courseCode;
    }
    /**
     * Creates a course code
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    /**
     * Returns the lecture code
     */
    public String getLectureCode() {
        return lectureCode;
    }
    /**
     * Creates the lecture code
     */
    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }
    /**
     * Returns the tutorial code
     */
    public String getTutorialCode() {
        return tutorialCode;
    }
    /**
     * Creates a tutorial code
     */
    public void setTutorialCode(String tutorialCode) {
        this.tutorialCode = tutorialCode;
    }
}
