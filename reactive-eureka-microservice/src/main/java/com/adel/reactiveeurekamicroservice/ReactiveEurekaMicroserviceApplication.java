package com.adel.reactiveeurekamicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ReactiveEurekaMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveEurekaMicroserviceApplication.class, args);
    }

}
