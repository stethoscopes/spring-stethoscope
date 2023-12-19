package org.dev.stethoscope.constants.swagger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SwaggerConstants {

    public static final String VERSION = "1.0.0";
    public static final String TITLE = "COMPANY INFO REST API";
    public static final String DESCRIPTION = "COMPANY INFO REST API DOCUMENTATION";
    public static final String LICENSE = "Apache License Version 2.0";
    public static final String LICENSE_URL = "https://www.apache.org/licenses/LICENSE-2.0";

    public static final String DEFAULT_TITLE = "default";

    public static final String PUBLIC_API_PATH = "/public/**";

    public static final String BEARER_SCHEME = "bearer";
    public static final String JWT = "jwt";
    public static final String BASIC_SCHEME = "Basic";
    public static final String BASIC_AUTH = "basicAuth";
}
