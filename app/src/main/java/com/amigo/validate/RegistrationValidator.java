package com.amigo.validate;

import com.amigo.config.ErrorStringConfig;
import com.amigo.form.RegistrationForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * RegistrationValidator
 */
@Service
public class RegistrationValidator implements Validator {

    @Autowired
    ErrorStringConfig errorStrings;
    /**
     * This method restricts the validator to only validate registration forms.
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return RegistrationForm.class.equals(clazz);
    }
    /**
     * Validates the registration form
     */
    @Override
    public void validate(Object target, Errors errors) {
        RegistrationForm form = (RegistrationForm) target;
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", errorStrings.PSWD_NOT_MATCH);
        }
    }
}