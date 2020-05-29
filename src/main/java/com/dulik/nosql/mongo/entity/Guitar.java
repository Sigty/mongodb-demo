package com.dulik.nosql.mongo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Guitar {

    @Id
    private String id;
    private String model;
    private Double price;
}
