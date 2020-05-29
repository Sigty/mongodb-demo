package com.dulik.nosql.mongo.repository;

import com.dulik.nosql.mongo.entity.Guitar;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends MongoRepository<Guitar, String> {
}
