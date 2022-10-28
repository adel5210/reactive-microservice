package com.adel.reactivemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableReactiveFeignClients(basePackages = "com.adel.reactivewebclient")
public class ReactiveStorageMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveStorageMicroserviceApplication.class, args);
    }

}
