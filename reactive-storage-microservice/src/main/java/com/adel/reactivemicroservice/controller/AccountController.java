package com.adel.reactivemicroservice.controller;

import com.adel.reactivemicroservice.model.Account;
import com.adel.reactivemicroservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customer")
public class AccountController {

    private final AccountRepository repository;

    @GetMapping("/{customer}")
    public Flux<Account> findByCustomer(@PathVariable("customer") String customerId){
        log.info("findByCustomer: customerId: {}", customerId);
        return repository.findByCustomerId(customerId);
    }

    @GetMapping
    public Flux<Account> findAll(){
        log.info("findAll");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Account> findById(@PathVariable("id") String id){
        log.info("findById: id={}", id);
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Account> create(@RequestBody Account account){
        log.info("create: {}", account);
        return repository.save(account);
    }

}
