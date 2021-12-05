package com.amigo.control;

import com.amigo.form.CourseForm;
import com.amigo.form.CourseFormList;
import com.amigo.form.InterestForm;
import com.amigo.form.RegistrationForm;
import com.amigo.user.UserBuilder;
import com.amigo.validate.CourseValidator;
import com.amigo.validate.RegistrationValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for account creation.
 * <p>
 * This controller is used throughout the user registration process (currently 3
 * screens). Once registration is successful, a new {@code User} object is
 * created and control is passed on to {@link DashboardController}.
 */
@Controller
public class RegistrationController {

    /**
     * Validator that validates registration form.
     */
    @Autowired
    RegistrationValidator validator;

    @Autowired
    CourseValidator courseValidator;

    @Autowired
    UserBuilder userBuilder;
    
    @GetMapping({"/", "/index"})
    public String showWelcomePage(Model model) {
        model.addAttribute("regForm", new RegistrationForm());
        return "index";
    }
    
    /**
     * Uses the validator to make sure registration form is valid.
     * 
     * @param form a Data Access Object representing the registration form
     */
    @PostMapping({"/", "/index"})
    public String validateRegistration(Model model, @ModelAttribute("regForm") RegistrationForm form, BindingResult result) {
        validator.validate(form, result);
        
        if (result.hasErrors()) {
            model.addAttribute("errorMessage", result.getAllErrors().get(0).getCode());
            return "index";
        }
        userBuilder.populate(form);
        return "redirect:/register-courses";
    }

    @GetMapping("/register-courses")
    public String showRegisterCoursePage(Model model) {
        model.addAttribute("courseForms", new CourseFormList());
        return "register-courses";
    }

    @PostMapping("/register-courses")
    public String validateCourses(Model model, @ModelAttribute CourseFormList courseForms, BindingResult result) {
        for (CourseForm form : courseForms.getCourseList()) {
            courseValidator.validate(form, result);
        }

        if (result.hasErrors()) {
            model.addAttribute("errorMessage", result.getAllErrors().get(0).getCode());
            model.addAttribute("courseForms", new CourseFormList());
            return "register-courses";
        }
        
        userBuilder.populate(courseForms);
        return "redirect:/register-interests";
    }

    @GetMapping("/register-interests")
    public String showRegisterInterestPage(Model model) {
        model.addAttribute("interestForm", new InterestForm());
        return "register-interests";
    }

    @PostMapping("/register-interests")
    public String validateInterests(RedirectAttributes attributes, @ModelAttribute("interestForm") InterestForm interestForm) {
        userBuilder.populate(interestForm);
        attributes.addFlashAttribute("user", userBuilder.createUser());
        return "redirect:/dashboard";
    }
}
