package com.amigo.control;

import com.amigo.form.RegistrationForm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for account creation.
 */
@Controller
public class RegistrationController {
    
    @GetMapping("/")
    public String showWelcomePage(Model model) {
        model.addAttribute("regForm", new RegistrationForm());
        return "index";
    }
    
    @GetMapping("/input-courses")
    public String showInputCourses(Model model) {
        return "input-courses";
    }
}
