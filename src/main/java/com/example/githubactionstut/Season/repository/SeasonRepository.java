package com.example.githubactionstut.Season.repository;

import com.example.githubactionstut.Season.model.Season;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface SeasonRepository extends ReactiveMongoRepository<Season, String> {

    @Query("{year:  ?0}")
    public Mono<Season> findSeasonByYear(Long year);
}
