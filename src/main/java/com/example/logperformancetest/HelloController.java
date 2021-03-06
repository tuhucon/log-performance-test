package com.example.logperformancetest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.context.Theme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Data
    @AllArgsConstructor
    public static class Person {
        Integer age;
        String name;
        Integer count;

        synchronized String lockMethod() {
            return "string from lock Method";
        }

        String noLockMethod() {
            return "string from no lock Metho";
        }
    }

    @GetMapping("/hello")
    public Person hello(@RequestParam Integer count) {
        for (int i = 0; i < count; i++) {
            logger.info("test performance {}", i);
        }
        return new Person(12, "tu hu con", count);
    }

    @GetMapping("/lock")
    public String testLock() {
        var p = new Person(12, "tu hu con", 12);
        return p.lockMethod();
    }

    @GetMapping("/nolock")
    public String testNoLock() {
        var p = new Person(12, "tu hu con", 12);
        return p.noLockMethod();
    }

    @GetMapping("/testLogSequence")
    public String testLogSequence() {
        logger.info("Controller method in Thread id: " + Thread.currentThread().getId() + " Thread name: " + Thread.currentThread().getName());
        return "tu hu con";
    }
}
