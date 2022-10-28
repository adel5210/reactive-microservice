package com.adel.reactivebackupstoragemicroservice.controller;

import com.adel.reactivebackupstoragemicroservice.service.LogsService;
import com.adel.reactivewebclient.logs.LogsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/logs")
public class LogsController {

    private final LogsService logsService;

    @PostMapping
    public Mono<String> processToLogs(@RequestBody LogsDto logsDto){
        log.info("processToLogs: "+logsDto.getData());
        return logsService.processToLog(logsDto);
    }

}
