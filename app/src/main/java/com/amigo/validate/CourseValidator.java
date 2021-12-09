package com.amigo.validate;

import java.util.regex.Pattern;

import com.amigo.config.ErrorStringConfig;
import com.amigo.form.CourseForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validator that validates course forms.
 */
@Service
public class CourseValidator implements Validator {

    @Autowired
    private ErrorStringConfig errorStrings;


    private static final Pattern COURSE_PATTERN = Pattern.compile("[A-Z]{3}\\d{3}");
    private static final Pattern LEC_PATTERN = Pattern.compile("LEC\\d{4}");
    private static final Pattern TUT_PATTERN = Pattern.compile("TUT\\d{4}");

    @Override
    public boolean supports(Class<?> clazz) {
        return CourseForm.class.equals(clazz);
    }

    /**
     * Validates form input for a course.
     * 
     * <p>{@inheritDoc}
     */
    @Override
    public void validate(Object target, Errors errors) {
        CourseForm form = (CourseForm) target;
        if (!COURSE_PATTERN.matcher(form.getCourseCode()).matches()) {
            errors.reject(errorStrings.COURSE_INFO_FORMAT);
        }
        if (!LEC_PATTERN.matcher(form.getLectureCode()).matches()) {
            errors.reject(errorStrings.COURSE_INFO_FORMAT);
        }
        if (!TUT_PATTERN.matcher(form.getTutorialCode()).matches()) {
            errors.reject(errorStrings.COURSE_INFO_FORMAT);
        }
    }
    
}
