package com.amigo.control;

import java.util.List;

import com.amigo.course.Course;
import com.amigo.course.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller for database
 */

@Controller
@RequestMapping(path="/data")
public class DatabaseController {
    // @Autowired


    @Autowired
    private CourseRepository courseRepository;

    /**
    //  * Returns "saved" if a course is added (saved) to the database
    //  */

    @PostMapping(path="/addcourse")
    public @ResponseBody String addNewCourse(@RequestParam String courseCode, @RequestParam String tutorialCode, @RequestParam String lectureCode) {
        Course course = new Course(courseCode, lectureCode, tutorialCode);
        courseRepository.save(course);
        return "Saved";
    }
    /**
     //  * Returns "saved" if a course is added (saved) to the database
     //  */
    @GetMapping("/testaddcourse")
    public @ResponseBody String testAddCourse() {
        Course course = new Course("CSC101", "LEC0101", "TUT0101");
        courseRepository.save(course);
        return "Saved";
    }

    /**
     * Returns all the courses saved in the database
     */

    @GetMapping(path="/allcourses")
    public @ResponseBody List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
