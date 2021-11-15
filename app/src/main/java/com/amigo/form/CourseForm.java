package com.amigo.form;

public class CourseForm {

    private String courseCode;
    private String lectureCode;
    private String tutorialCode;

    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        System.out.println(courseCode);
        this.courseCode = courseCode;
    }
    public String getLectureCode() {
        return lectureCode;
    }
    public void setLectureCode(String lectureCode) {
        this.lectureCode = lectureCode;
    }
    public String getTutorialCode() {
        return tutorialCode;
    }
    public void setTutorialCode(String tutorialCode) {
        this.tutorialCode = tutorialCode;
    }
}
