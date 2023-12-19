package org.dev.stethoscope.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.core.env.Environment;

import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpringProfiles {
    // 서버 종류
    public static final String LC_DEVELOPMENT = "lc-development";
    public static final String KR_DEVELOPMENT = "kr-development";
    public static final String KR_STAGING = "kr-staging";
    public static final String KR_STAGING2 = "kr-staging2";
    public static final String KR_PRODUCTION = "kr-production";

    /**
     * 활성화된 프로필인가?
     */
    public static boolean isActive(Environment env, String... targetProfiles) {
        return Stream.of(env.getActiveProfiles())
                .anyMatch(p -> {
                    for (String profile : targetProfiles) {
                        if (p.equals(profile)) {
                            return true;
                        }
                    }
                    return false;
                });
    }

    public static String getChiefActiveProfile(Environment env) {
        String[] profiles = env.getActiveProfiles();
        if (profiles.length < 1) {
            throw new IllegalStateException("Active Profile Not Found");
        }
        return profiles[0];
    }
}
