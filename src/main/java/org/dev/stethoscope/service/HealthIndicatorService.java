package org.dev.stethoscope.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthIndicatorService {
    @Value("${project.version}")
    private String version;

    public String getProjectVersion() {
        return version;
    }
}
