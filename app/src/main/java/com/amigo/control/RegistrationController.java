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

    /**
     * Validates registration.
     */
    @Autowired
    RegistrationValidator validator;
    
    @GetMapping("/")
    public String showWelcomePage(Model model) {
        model.addAttribute("regForm", new RegistrationForm());
        return "index";
    }
    
    @PostMapping("/")
    public String validateRegistration(Model model, @ModelAttribute("regForm") RegistrationForm form) {
        boolean isValidRegistration = validator.validateRegistration();
        
        // this doesn't work yet
        if (!isValidRegistration) {
            model.addAttribute("errorMessage", "This means you failed.");
            return "index";
        }
        return "redirect:/register-courses";
    }

    @GetMapping("/register-courses")
    public String showRegisterCoursePage(Model model) {
        model.addAttribute("courseForm", "hello");
        System.out.println("print");
        return "register-courses";
    }
}
