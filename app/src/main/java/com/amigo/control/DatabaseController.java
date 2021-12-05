package com.amigo.control;

import java.util.List;

import com.amigo.course.Course;
import com.amigo.course.CourseRepository;
import com.amigo.course.CourseSetFactory;
import com.amigo.user.Profile;
import com.amigo.user.User;
import com.azure.core.credential.AzureKeyCredential;
// import com.amigo.user.UserRepository;
// import com.amigo.course.CourseRepository;
// // import com.amigo.user.UserRepository;
import com.azure.spring.autoconfigure.cosmos.CosmosProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Controller for database
 */
@Controller
@RequestMapping(path="/data")
public class DatabaseController {
    @Autowired
    private CosmosProperties properties;

    @Autowired
    private AzureKeyCredential azureKeyCredential;

    // @Autowired
    // private UserRepository userRepository;

    /**
     * Returns "saved" if the test user is added (saved) to the database
     */
    // @PostMapping(path="/testadduser")
    // public @ResponseBody String addTestUser() {
    //     CourseSetFactory courseSetFactory = new CourseSetFactory();
    //     HashSet<Course> courses = courseSetFactory.createCourseSet("CSC207,LIN101,LIN102");
    //     Profile profile = new Profile("Tony Hu", 2, "Linguistics", courses, "@cutie");
    //     User user = new User(profile, "hu001");
    //     final Mono<User> savedTestUser = userRepository.save(user);
    //     return "Saved";
    // }

    @Autowired
    private CourseRepository courseRepository;

    /**
     * Returns "saved" if the test user is added (saved) to the database
     */
    @GetMapping(path="/testaddcourse")
    public @ResponseBody String addTestCourse() {
        // CourseSetFactory courseSetFactory = new CourseSetFactory();
        // HashSet<Course> courses = courseSetFactory.createCourseSet("CSC207,LIN101,LIN102");
        // Profile profile = new Profile("Tony Hu", 2, "Linguistics", courses, "@cutie");
        // User user = new User(profile, "hu001");
        // final Mono<User> savedTestCourse = courseRepository.save(user);

        final Course course = new Course("CSC207", "LEC0101", "TUT0102");
        final Mono<Course> savedTestCourse = courseRepository.save(course);
        return "Saved";
    }


    // /**
    //  * Returns "saved" if a course is added (saved) to the database
    //  */

    @PostMapping(path="/addcourse")
    public @ResponseBody String addNewCourse(@RequestParam String courseCode, @RequestParam String tutorialCode, @RequestParam String lectureCode) {
        Course course = new Course(courseCode, lectureCode, tutorialCode);
        courseRepository.save(course);
        return "Saved";
    }

    /**
     * Returns all the courses saved in the database
     */
    @GetMapping(path="/allcourses")
    public @ResponseBody List<Course> getAllCourses() {
        Mono<List<Course>> coursesMono = courseRepository.findAll().collectList();
        List<Course> courses = coursesMono.block();
        return courses;
    }
}
