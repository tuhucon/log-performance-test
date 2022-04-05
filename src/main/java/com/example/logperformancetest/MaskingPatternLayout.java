package com.example.logperformancetest;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class MaskingPatternLayout extends PatternLayout {

    @Override
    public String doLayout(ILoggingEvent event) {
        System.out.println("MaskingPatternLayout > doLayout > Thread id: " + Thread.currentThread().getId() +
                " Thread name: " + Thread.currentThread().getName());
        return event.getMessage();
    }

}
