package org.dev.stethoscope.config;

import org.dev.stethoscope.constants.SpringProfiles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;

@Configuration
public class PropertySourceConfig {
    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(
            ConfigurableEnvironment environment) throws IOException {
        String profile = SpringProfiles.getChiefActiveProfile(environment);

        String propertiesPath = "/properties/";

        Resource[] resources = new Resource[]{
                new ClassPathResource(propertiesPath + "version.properties")
        };

        for (Resource r : resources) {
            if (!r.exists()) {
                continue;
            }
            environment.getPropertySources().addFirst(
                    new PropertiesPropertySource(r.getFilename(), PropertiesLoaderUtils.loadProperties(r)));
        }

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(resources);
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }
}
