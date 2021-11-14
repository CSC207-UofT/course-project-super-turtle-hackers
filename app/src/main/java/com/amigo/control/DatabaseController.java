package com.amigo.control;

import java.util.List;
import com.amigo.course.Course;
import com.amigo.course.CourseRepository;
// import com.amigo.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/amigo")
public class DatabaseController {
    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping(path="/addcourse")
    public @ResponseBody String addNewCourse(@RequestParam String courseCode) {
        Course course = new Course(courseCode);
        courseRepository.save(course);
        return "Saved";
    }

    @PostMapping(path="/all")
    public @ResponseBody List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}