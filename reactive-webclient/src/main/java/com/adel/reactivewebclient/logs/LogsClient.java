package com.adel.reactivewebclient.logs;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(value = "reactive-backup-storage-microservice", url = "http://REACTIVE-BACKUP-STORAGE-MICROSERVICE")
public interface LogsClient {

    @PostMapping("api/logs")
    Mono<String> processToLogs(@RequestBody LogsDto logsDto);
}
