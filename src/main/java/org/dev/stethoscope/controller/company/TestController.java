package org.dev.stethoscope.controller.company;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.dev.stethoscope.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "test")
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController extends BaseController {

    @GetMapping
    public boolean isTrue(@Parameter(description = "bool 값") @RequestParam boolean bool) {
        return bool;
    }
}
