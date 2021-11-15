package com.amigo.control;

import com.amigo.form.RegistrationForm;
import com.amigo.form.RegistrationValidator;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    RegistrationValidator validator;
    
    @GetMapping("/")
    public String showWelcomePage(Model model) {
        model.addAttribute("regForm", new RegistrationForm());
        return "index";
    }
    
    @GetMapping("/register-courses")
    public String showInputCourses(Model model, @ModelAttribute("regForm") RegistrationForm form) {
        boolean isValidRegistration = validator.validateRegistration();
        
        if (!isValidRegistration) {
            model.addAttribute("errorMessage", "This means you failed.");
            return "index";
        }
        return "register-courses";
    }
}
