package com.adel.reactivewebclient.storage;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;

@FeignClient(value = "reactive-storage-microservice")
public interface StorageClient {

    @GetMapping("/api/customer/{customer}")
    Flux<AccountDto> findByCustomer(@PathVariable("customer") String customerId);
}
