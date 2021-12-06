package com.amigo.control;

import com.amigo.form.LoginForm;

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
        model.addAttribute("credentials", new LoginForm());
        return "log-in";
    }

    /**
     * Returns "greeting" once the system finds the html file and calls on it.
     */

    @PostMapping("/login-success")
    public String getCredentials(Model model, @ModelAttribute("credentials") LoginForm cred) {
        model.addAttribute("name", cred.getUsername());
        return "log-in-success";
    }
    
}
