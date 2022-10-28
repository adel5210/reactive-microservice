package com.adel.reactivebackupstoragemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import reactivefeign.spring.config.EnableReactiveFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableReactiveFeignClients(basePackages = "com.adel.reactivewebclient")
public class ReactiveBackupStorageMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveBackupStorageMicroserviceApplication.class, args);
    }

}
