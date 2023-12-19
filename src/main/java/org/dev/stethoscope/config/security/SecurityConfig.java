package org.dev.stethoscope.config.security;

import lombok.RequiredArgsConstructor;
import org.dev.stethoscope.constants.SpringProfiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final Environment environment;

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().requestMatchers("/", "/version", "/favicon.ico", "/health", "/health.html", "/robots.txt");
            if (!environment.acceptsProfiles(Profiles.of(SpringProfiles.KR_PRODUCTION))) { // 운영 환경은 swagger 접근 불가
                web.ignoring().requestMatchers("/swagger-ui/**", "/swagger-resources/**", "/v3/api-docs/**");
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(HttpBasicConfigurer::disable)
                .csrf(CsrfConfigurer::disable)
                .cors(Customizer.withDefaults())
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
                .formLogin(FormLoginConfigurer::disable)
                .logout(LogoutConfigurer::disable);

        http.authorizeHttpRequests(authorize ->
                authorize.anyRequest().authenticated()
        );

        return http.build();
    }

}
