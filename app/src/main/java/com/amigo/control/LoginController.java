package com.amigo.control;

import com.amigo.login.Credentials;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for login activities.
 */
@Controller
public class LoginController {

    /**
     * Returns "login" if credentials are saved to the model
     */
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "login";
    }

    /**
     * Returns "greeting" once the system finds the html file and calls on it.
     */
    @PostMapping("/auth")
    public String getCredentials(Model model, @ModelAttribute("credentials") Credentials cred) {
        model.addAttribute("name", cred.getUsername());
        return "greeting";
    }
    
}
