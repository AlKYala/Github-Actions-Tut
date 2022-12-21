package com.example.githubactionstut.Car.repository;

import com.example.githubactionstut.Car.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CarRepository extends ReactiveMongoRepository<Car, String> {
}
