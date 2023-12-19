package org.dev.stethoscope.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.dev.stethoscope.constants.swagger.SwaggerConstants.BASIC_AUTH;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.BASIC_SCHEME;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.BEARER_SCHEME;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.DEFAULT_TITLE;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.DESCRIPTION;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.JWT;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.LICENSE;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.LICENSE_URL;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.TITLE;
import static org.dev.stethoscope.constants.swagger.SwaggerConstants.VERSION;


@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title(DEFAULT_TITLE)
                .description(DESCRIPTION)
                .version(VERSION);
    }

    static {
        SpringDocUtils.getConfig()
                .replaceWithClass(LocalDateTime.class, String.class)
                .replaceWithClass(LocalDate.class, String.class)
                .replaceWithClass(LocalTime.class, String.class);
    }

    @Bean
    public OpenAPI getOpenApi() {
        Components components = new Components()
                .addSecuritySchemes(BASIC_AUTH, getBasicSecurityScheme())
                .addSecuritySchemes(JWT, getJwtSecurityScheme());
        SecurityRequirement securityItem = new SecurityRequirement()
                .addList(BASIC_AUTH)
                .addList(JWT);
        Server server = new Server().url("/");

        return new OpenAPI()
                .info(getApiInfo())
                .components(components)
                .addSecurityItem(securityItem)
                .addServersItem(server);
    }

    private Info getApiInfo() {
        return new Info()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .license(new License().name(LICENSE).url(LICENSE_URL));
    }

    private SecurityScheme getJwtSecurityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme(BEARER_SCHEME)
                .bearerFormat(JWT)
                .in(SecurityScheme.In.HEADER)
                .name(HttpHeaders.AUTHORIZATION);
    }

    private SecurityScheme getBasicSecurityScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme(BASIC_SCHEME);
    }

}
