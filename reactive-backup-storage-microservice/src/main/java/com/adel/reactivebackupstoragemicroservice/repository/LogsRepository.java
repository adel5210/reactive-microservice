package com.adel.reactivebackupstoragemicroservice.repository;

import com.adel.reactivebackupstoragemicroservice.model.Logs;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends ReactiveMongoRepository<Logs, String> {

}
