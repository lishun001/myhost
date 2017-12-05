package com.eason.task.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceSchedulerApplication.class, args);
    }
}
