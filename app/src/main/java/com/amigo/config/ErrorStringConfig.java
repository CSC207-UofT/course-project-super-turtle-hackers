package com.amigo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * A POJO class that holds String constants for error messages.
 */
@ConfigurationProperties(prefix = "error")
@ConstructorBinding     // to make the object immutable
public class ErrorStringConfig {
    private final String pswdNotMatch;

    public ErrorStringConfig(String pswdNotMatch) {
        this.pswdNotMatch = pswdNotMatch;
    }

    public String getPswdNotMatch() {
        return pswdNotMatch;
    }
}
