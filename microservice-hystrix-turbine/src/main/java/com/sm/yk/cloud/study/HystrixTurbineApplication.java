package com.sm.yk.cloud.study;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Created by youkai on 2017/9/13.
 */
@SpringBootApplication
@EnableTurbine
public class HystrixTurbineApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HystrixTurbineApplication.class).web(true).run(args);
    }
}
