package com.adel.reactivemicroservice.controller;

import com.adel.reactivemicroservice.model.Account;
import com.adel.reactivemicroservice.service.AccountService;
import com.adel.reactivewebclient.storage.AccountDto;
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

    private final AccountService service;

    @GetMapping("/{customer}")
    public Flux<AccountDto> findByCustomer(@PathVariable("customer") String customerId){
        return service.findByCustomer(customerId);
    }

    @GetMapping
    public Flux<AccountDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<AccountDto> findById(@PathVariable("id") String id){
        return service.findById(id);
    }

    @PostMapping
    public Mono<AccountDto> create(@RequestBody Account account) {
        return service.create(account);
    }
}
