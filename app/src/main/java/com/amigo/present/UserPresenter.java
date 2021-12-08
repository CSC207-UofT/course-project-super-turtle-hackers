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

    /**
     * The suffix used to distinguish each attribute set.
     */
    private String suffix = "";

    /**
     * Returns whether there is currently a {@code User} object associated with this
     * presenter.
     */
    public boolean hasUser() {
        return user != null;
    }
    /**
     * Returns the user
     */
    public User getUser() {
        return user;
    }
    /**
     * Creates a user
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Returns the suffix
     */
    public String getSuffix() {
        return suffix;
    }
    /**
     * Creates a suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
    
    /**
     * Populates the ModelMap with attributes taken from the user.
     */
    public void populate(Map<String, Object> map) {
        if (user == null) {
            throw new IllegalStateException("User not set with setUser()");
        }
        map.put("name" + (suffix.equals("") ? "" : "_" + suffix), user.getProfile().getName());
        map.put("hobbies" + (suffix.equals("") ? "" : "_" + suffix), user.getProfile().getHobbies());
        map.put("sports" + (suffix.equals("") ? "" : "_" + suffix), user.getProfile().getSportInterest());
        map.put("music" + (suffix.equals("") ? "" : "_" + suffix), user.getProfile().getMusInterest());
        map.put("recreational" + (suffix.equals("") ? "" : "_" + suffix), user.getProfile().getRecInterest());
        map.put("courses" + (suffix.equals("") ? "" : "_" + suffix), user.getProfile().getCoursesAsString());
    }
}
