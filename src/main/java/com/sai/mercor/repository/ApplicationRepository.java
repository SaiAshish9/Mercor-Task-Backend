package com.sai.mercor.repository;

import com.sai.mercor.entity.Application;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ApplicationRepository extends MongoRepository<Application, String> {
    List<Application> findByLocation(String location);

    @Query("{ 'work_availability': ?0 }")
    List<Application> findByWorkAvailability(String type);
}
