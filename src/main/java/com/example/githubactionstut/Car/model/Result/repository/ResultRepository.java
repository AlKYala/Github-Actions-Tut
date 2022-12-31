package com.example.githubactionstut.Car.model.Result.repository;

import com.example.githubactionstut.Car.model.Result.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ResultRepository extends ReactiveMongoRepository<Result, String> {
}
