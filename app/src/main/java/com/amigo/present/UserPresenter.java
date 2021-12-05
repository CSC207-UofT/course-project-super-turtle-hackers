package com.amigo.present;

import java.util.Map;

import com.amigo.user.User;

import org.springframework.stereotype.Controller;

/**
 * A presenter that populates the model for dashboard page given a specific
 * user.
 */
@Controller
public class UserPresenter {
    
    private User user;


    public void setUser(User user) {
        this.user = user;
    }
    
    /**
     * Populates the ModelMap with attributes taken from the user.
     */
    public void populate(Map<String, Object> map) {
        if (user == null) {
            throw new IllegalStateException("User not set with setUser()");
        }
        map.put("name", user.getProfile().getName());
        map.put("hobbies", user.getProfile().getHobbies());
        map.put("sports", user.getProfile().getSportInterest());
        map.put("music", user.getProfile().getMusInterest());
        map.put("recreational", user.getProfile().getRecInterest());
        map.put("courses", user.getProfile().getCoursesAsString());
    }
}
