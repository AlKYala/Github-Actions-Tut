package com.example.githubactionstut.Season.service;

import com.example.githubactionstut.Driver.model.Driver;
import com.example.githubactionstut.Season.model.Season;
import com.example.githubactionstut.Season.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeasonServiceImpl implements SeasonServiceReactive {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private ReactiveMongoTemplate mongoTemplate;

    @Override
    public Mono<Season> findById(String id) {
        return seasonRepository.findById(id);
    }

    @Override
    @Cacheable("seasons")
    public Flux<Season> findAll() {
        return seasonRepository.findAll().log();
    }

    @Override
    public Flux<Season> findAllPaginated(int page, int size) {
        PageRequest pagination = PageRequest.of(page, size);

        return this.seasonRepository.findAll().take(size).skip(page * size);
    }

    @Override
    public Mono<Season> findByYear(Long year) {
        return seasonRepository.findSeasonByYear(year);
    }

    @Override
    public Mono<Season> save(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public Mono<Season> update(Season season) {
        //leaving out special update logic because this is just a demo
        return seasonRepository.save(season);
    }

    @Override
    public String delete(Season season) {
        seasonRepository.delete(season);
        return season.getId();
    }

    public void foo() {
        Integer counter = 0;
        this.findAll().subscribe(
                season -> log.info(season.getYear().toString())
        );
    }
}
