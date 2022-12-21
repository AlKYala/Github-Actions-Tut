package com.example.githubactionstut.Team.repository;

import com.example.githubactionstut.Team.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface TeamRepository extends ReactiveMongoRepository<Team, String> {

    public Mono<Team> findTeamByName(String name);
}
