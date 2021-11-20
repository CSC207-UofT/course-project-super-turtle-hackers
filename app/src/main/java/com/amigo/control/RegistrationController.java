package com.amigo.control;

import javax.servlet.http.HttpServletRequest;

import com.amigo.form.CourseForm;
import com.amigo.form.RegistrationForm;
import com.amigo.form.RegistrationValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for account creation.
 */
@Controller
public class RegistrationController {

    /**
     * Validator that validates registration form.
     */
    @Autowired
    RegistrationValidator validator;
    
    @GetMapping("/")
    public String showWelcomePage(Model model) {
        model.addAttribute("regForm", new RegistrationForm());
        return "index";
    }
    
    /**
     * Uses the validator to make sure registration form is valid.
     * 
     * @param form a Data Access Object representing the registration form
     */
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
        model.addAttribute("courseForm1", new CourseForm());
        model.addAttribute("courseForm2", new CourseForm());
        return "register-courses";
    }

    // @PostMapping("/register-courses")
    // public String validateCourses(HttpServletRequest request, RedirectAttributes attributes,
    //         @ModelAttribute("courseForm1") CourseForm form1, @ModelAttribute("courseForm2") CourseForm form2) {
    //     // TODO: figure out why two objects don't work in form
    //     // redirect a POST request to another POST request
    //     request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
    //     // add request parameter
    //     // attributes.addAttribute("courseCode", form1.getCourseCode());
    //     return "redirect:/data/addcourse";
    // }

    @PostMapping("/register-courses")
    public String validateCourses() {
        return "redirect:/register-interests";
    }

    @GetMapping("/register-interests")
    public String showRegisterInterestPage() {
        return "register-interests";
    }
}
