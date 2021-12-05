package com.amigo.user;

import com.amigo.course.Course;
import com.amigo.form.CourseForm;
import com.amigo.form.CourseFormList;
import com.amigo.form.InterestForm;
import com.amigo.form.RegistrationForm;

import org.springframework.stereotype.Service;

/**
 * Builder for {@code User} objects.
 */
@Service
public class UserBuilder {
    
    // TODO: assign ID to user
    private User user;
    private Profile profile;
    
    public UserBuilder() {
        this.reset();
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
    public void populate(CourseFormList form) {
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
        String id = this.profile.getName().split(" ")[0].toLowerCase() + (int) (1000 * Math.random() + 1);
        user.setId(id);
        User u = this.user;
        reset();
        return u; 
    }
    
    /**
     * Discards all previous attributes.
     */
    private void reset() {
        user = new User();
        profile = new Profile();
    }
}
