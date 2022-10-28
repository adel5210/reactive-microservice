package com.adel.reactivebackupstoragemicroservice.service;

import com.adel.reactivebackupstoragemicroservice.model.Logs;
import com.adel.reactivebackupstoragemicroservice.repository.LogsRepository;
import com.adel.reactivewebclient.logs.LogsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class LogsService {

    private final LogsRepository logsRepository;

    @Transactional
    public Mono<String> processToLog(final LogsDto logsDto){
        return logsRepository.save(Logs.builder()
                .createdDate(new Date())
                .data(logsDto.getData())
                .success(logsDto.getSuccess())
                .build())
                .map(m->m.getId());
    }

}
