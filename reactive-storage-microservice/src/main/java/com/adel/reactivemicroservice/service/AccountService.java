package com.adel.reactivemicroservice.service;

import com.adel.reactivemicroservice.model.Account;
import com.adel.reactivemicroservice.repository.AccountRepository;
import com.adel.reactivewebclient.logs.LogsClient;
import com.adel.reactivewebclient.logs.LogsDto;
import com.adel.reactivewebclient.logs.LogsDtoBuilder;
import com.adel.reactivewebclient.storage.AccountDto;
import com.adel.reactivewebclient.storage.AccountDtoBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final WebClient.Builder webClientBuilder;
    private final AccountRepository repository;
    private final LogsClient logsClient;

    @Transactional
    public Flux<AccountDto> findByCustomer(String customerId){
        log.info("findByCustomer: customerId: {}", customerId);
        final Flux<AccountDto> result = repository.findByCustomerId(customerId).map(m ->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build());
        return result;
    }

    @Transactional
    public Flux<AccountDto> findAll(){
        log.info("findAll");
        return repository.findAll().map(m->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build());
    }

    @Transactional
    public Mono<AccountDto> findById(String id){
        log.info("findById: id={}", id);
        return repository.findById(id).map(m->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build());
    }

    @Transactional
    public Mono<AccountDto> create(Account account){
        log.info("create: {}", account);
        final Mono<String> monoLogs = logsClient.processToLogs(LogsDtoBuilder.aLogsDto()
                .data(account.getCustomerId())
                .success(true)
                .build());
//        final Mono<String> monoLogs = webClientBuilder.build().post()
//                .uri("http://REACTIVE-BACKUP-STORAGE-MICROSERVICE/api/logs")
//                .body(Mono.just(LogsDtoBuilder.aLogsDto()
//                        .data(account.getCustomerId())
//                        .success(true)
//                        .build()), LogsDto.class)
//                .exchangeToMono(exc -> exc.bodyToMono(String.class));
        final Mono<AccountDto> result = repository.save(account).map(m ->
                AccountDtoBuilder.anAccountDto()
                        .amount(m.getAmount())
                        .number(m.getNumber())
                        .customerId(m.getCustomerId())
                        .build())
                .zipWith(monoLogs)
                .map(m->m.getT1());
        return result;
    }

}
