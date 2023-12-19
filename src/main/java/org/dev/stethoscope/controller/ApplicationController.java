package org.dev.stethoscope.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dev.stethoscope.service.HealthIndicatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Hidden
@Slf4j
@RequiredArgsConstructor
@Controller
public class ApplicationController {

    private final HealthIndicatorService healthIndicatorService;

    @GetMapping("/")
    @ResponseBody
    public String main() {
        return healthIndicatorService.getVersion();
    }

    @GetMapping("/version")
    @ResponseBody
    public String checkVersion() {
        return healthIndicatorService.getVersion();
    }

    @GetMapping("/health.html")
    @ResponseBody
    public Boolean healthCheck() {
        return true;
    }

}
