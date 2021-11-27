package com.amigo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * A POJO class that holds String constants for error messages.
 */
@ConfigurationProperties(prefix = "error")
@ConstructorBinding     // specifies that config values should be injected through the constructor
                        // such that the object can be immutable
public class ErrorStringConfig {
    public final String PSWD_NOT_MATCH;
    public final String COURSE_INFO_FORMAT;

    public ErrorStringConfig(String pswdNotMatch, String courseInfoFormat) {
        this.PSWD_NOT_MATCH = pswdNotMatch;
        this.COURSE_INFO_FORMAT = courseInfoFormat;
    }
}
