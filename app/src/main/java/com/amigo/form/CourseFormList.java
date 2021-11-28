package com.amigo.form;

import java.util.ArrayList;
import java.util.List;

public class CourseFormList {
    
    private List<CourseForm> courseList;

    public CourseFormList() {
        courseList = new ArrayList<>();
        courseList.add(new CourseForm());
        courseList.add(new CourseForm());
    }

    public List<CourseForm> getCourseList() {
        return courseList;
    }
    
    public void setCourseList(List<CourseForm> courseList) {
        this.courseList = courseList;
    }
}
