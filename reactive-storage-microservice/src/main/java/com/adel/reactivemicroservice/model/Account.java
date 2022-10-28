package com.adel.reactivemicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * MongoDB will work with annotations below
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Account {

    @Id
    private String id;
    private String number;
    private String customerId;
    private int amount;

}
