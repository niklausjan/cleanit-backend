package ch.cleanit.backend.controller;

import ch.cleanit.backend.model.TestResponse;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/test")
public class HelloController {

    @GetMapping
    public TestResponse hello() {
        return new TestResponse("backend ok");
    }
}
