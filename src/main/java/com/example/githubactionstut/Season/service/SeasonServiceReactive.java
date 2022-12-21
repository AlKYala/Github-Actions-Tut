package com.example.githubactionstut.Season.service;

import com.example.githubactionstut.Driver.model.Driver;
import com.example.githubactionstut.Season.model.Season;
import com.example.githubactionstut.Season.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SeasonServiceReactive {

    public Mono<Season> findById(String id);

    public Flux<Season> findAll();

    public Flux<Season> findAllPaginated(int page, int size);

    public Mono<Season> findByYear(Long year);

    public Mono<Season> save(Season season);

    public Mono<Season> update(Season season);

    public String delete(Season season);

    public void foo();
}
