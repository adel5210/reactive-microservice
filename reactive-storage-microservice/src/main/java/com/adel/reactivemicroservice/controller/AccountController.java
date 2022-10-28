package com.adel.reactivemicroservice.controller;

import com.adel.reactivemicroservice.model.Account;
import com.adel.reactivemicroservice.repository.AccountRepository;
import com.adel.reactivewebclient.storage.AccountDto;
import com.adel.reactivewebclient.storage.AccountDtoBuilder;
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
    public Flux<AccountDto> findByCustomer(@PathVariable("customer") String customerId){
        log.info("findByCustomer: customerId: {}", customerId);
        return repository.findByCustomerId(customerId).map(m->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build());
    }

    @GetMapping
    public Flux<AccountDto> findAll(){
        log.info("findAll");
        return repository.findAll().map(m->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build());
    }

    @GetMapping("/{id}")
    public Mono<AccountDto> findById(@PathVariable("id") String id){
        log.info("findById: id={}", id);
        return repository.findById(id).map(m->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build());
    }

    @PostMapping
    public Mono<AccountDto> create(@RequestBody Account account){
        log.info("create: {}", account);
        return repository.save(account).map(m->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build());
    }

}
