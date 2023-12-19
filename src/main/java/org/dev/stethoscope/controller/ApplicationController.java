package org.dev.stethoscope.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dev.stethoscope.service.HealthIndicatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@Controller
public class ApplicationController {

    private final HealthIndicatorService healthIndicatorService;

    @GetMapping("/")
    @ResponseBody
    public String main() {
        return healthIndicatorService.getProjectVersion();
    }

    @GetMapping("/version")
    @ResponseBody
    public String checkVersion() {
        return healthIndicatorService.getProjectVersion();
    }

    @GetMapping("/health.html")
    @ResponseBody
    public Boolean healthCheck() {
        return true;
    }

}
