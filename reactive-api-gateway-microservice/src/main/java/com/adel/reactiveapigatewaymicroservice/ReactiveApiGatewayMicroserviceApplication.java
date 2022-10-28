package com.adel.reactiveapigatewaymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReactiveApiGatewayMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveApiGatewayMicroserviceApplication.class, args);
    }

}
