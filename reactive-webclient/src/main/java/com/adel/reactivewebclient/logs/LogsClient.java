package com.adel.reactivewebclient.logs;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;

@FeignClient(value = "reactive-backup-storage-microservice")
public interface LogsClient {

    @PostMapping("api/logs")
    Mono<String> processToLogs(@RequestBody LogsDto logsDto);
}
