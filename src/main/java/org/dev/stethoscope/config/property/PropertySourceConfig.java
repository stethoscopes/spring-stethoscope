package org.dev.stethoscope.config.property;

import org.dev.stethoscope.constants.SpringProfiles;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.spring31.properties.EncryptablePropertiesPropertySource;
import org.jasypt.spring31.properties.EncryptablePropertySourcesPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;

@Configuration
public class PropertySourceConfig {

    @Primary
    @Bean
    StandardPBEStringEncryptor standardPBEStringEncryptor() {
        StandardPBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
        stringEncryptor.setAlgorithm(StandardPBEByteEncryptor.DEFAULT_ALGORITHM);
        stringEncryptor.setPassword("stethoscopepwd");
        return stringEncryptor;
    }

    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(
            ConfigurableEnvironment environment, StandardPBEStringEncryptor encryptor) throws IOException {
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
                    new EncryptablePropertiesPropertySource(r.getFilename(), PropertiesLoaderUtils.loadProperties(r), encryptor));
        }

        PropertySourcesPlaceholderConfigurer configurer = new EncryptablePropertySourcesPlaceholderConfigurer(encryptor);
        configurer.setLocations(resources);
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }
}
