package com.example.logperformancetest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Data
    @AllArgsConstructor
    public static class Person {
        Integer age;
        String name;
        Integer count;
    }

    @GetMapping("/hello")
    public Person hello(@RequestParam Integer count) {
        for (int i = 0; i < count; i++) {
            logger.info("test performance {}", i);
        }
        return new Person(12, "tu hu con", count);
    }
}
