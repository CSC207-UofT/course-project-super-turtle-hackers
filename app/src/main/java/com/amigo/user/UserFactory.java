package com.amigo.user;

import com.amigo.course.Course;
import com.amigo.form.CourseForm;
import com.amigo.form.CourseFormList;
import com.amigo.form.InterestForm;
import com.amigo.form.RegistrationForm;

import org.springframework.stereotype.Service;

/**
 * Factory that curates form input and creates a {@code User} object.
 */
@Service
public class UserFactory {

    private User user;
    private Profile profile;
    
    public UserFactory() {
        user = new User();
        profile = new Profile();
    }
    
    /**
     * Populates the {@code User} object with attributes from the registration form.
     */
    public void populate(RegistrationForm form) {
        profile.setName(form.getFirstName() + " " + form.getLastName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
    }

    /**
     * Populates the {@code User} object with attributes from the course form.
     */
    public void pupulate(CourseFormList form) {
        for (var each : form.getCourseList()) {
            populateCourse(each);
        }
    }
    
    private void populateCourse(CourseForm form) {
        Course c = new Course(form.getCourseCode(), form.getLectureCode(), form.getTutorialCode());
        profile.addCourses(c);
    }

    /**
     * Populates the {@code User} object with attributes from the interest form.
     */
    public void populate(InterestForm form) {
        profile.setHobbies(form.getHobbies());
        profile.setRecInterest(form.getRecreational());
        profile.setMusInterest(form.getMusic());
        profile.setSportInterest(form.getSports());
    }
    

    public User createUser() {
        user.setProfile(this.profile);
        return user; 
    }
    
    /**
     * Generates a random ID for a Profile and create a User using the Profile and ID.
     * @param profile a Profile object that contains all the information of the user
     * @return a new User object
     */
    @Deprecated
    public User createUser(Profile profile) {
        String name = profile.getName();
        String id = name.split(" ")[0].toLowerCase() + (int) (1000 * Math.random() + 1);
        String email = "maeve@gmail.com";
        String password = "password123";
        return new User(profile, id, email, password);
    }

}
