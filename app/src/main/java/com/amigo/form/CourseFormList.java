package com.amigo.form;

import java.util.ArrayList;
import java.util.List;

/**
 * Form backing data object for register-courses.
 */
public class CourseFormList {
    
    private List<CourseForm> courseList;

    public CourseFormList() {
        courseList = new ArrayList<>();
        courseList.add(new CourseForm());
        courseList.add(new CourseForm());
    }
    /**
     * Returns the courselist
     */
    public List<CourseForm> getCourseList() {
        return courseList;
    }
    /**
     * Creates a courselist
     */
    public void setCourseList(List<CourseForm> courseList) {
        this.courseList = courseList;
    }
}
