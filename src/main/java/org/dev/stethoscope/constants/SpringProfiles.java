package org.dev.stethoscope.constants;

import org.springframework.core.env.Environment;

public class SpringProfiles {
    public static final String LC_DEVELOPMENT = "lc-development";

    public static String getChiefActiveProfile(Environment env) {
        String[] profiles = env.getActiveProfiles();
        if (profiles.length < 1) {
            throw new IllegalStateException("Active Profile Not Found");
        }
        return profiles[0];
    }
}
