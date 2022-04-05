package com.example.logperformancetest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class LogPerformanceTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void tuhucon() {
        var x = new ArrayList<String>();
        var y = new ArrayList<String>();
        y.add("one");
        y.add("two");
        y.add("three");

        var count = y.stream().map(item -> {
            System.out.println("item = " + item);
            x.add(item);
            return item.toUpperCase();
        }).count();

        System.out.println(x);
        System.out.println("count = " + count);


    }

}
