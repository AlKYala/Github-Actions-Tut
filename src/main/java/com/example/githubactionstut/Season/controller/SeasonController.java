package com.example.githubactionstut.Season.controller;

import com.example.githubactionstut.Driver.model.Driver;
import com.example.githubactionstut.Season.model.Season;
import com.example.githubactionstut.Season.repository.SeasonRepository;
import com.example.githubactionstut.Season.service.SeasonService;
import com.example.githubactionstut.Season.service.SeasonServiceReactive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/season")
public class SeasonController {

    @Autowired
    private SeasonServiceReactive seasonService;

    @GetMapping("/{year}")
    public Mono<Season> getSeasonByYear(@PathVariable Long year) {
        return this.seasonService.findByYear(year);
    }
    @GetMapping(path = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Season> findAll() {
        return this.seasonService.findAll();
    }

    @GetMapping("/paginated")
    public Flux<Season> findPaginated(@RequestParam Integer page, @RequestParam Integer size) {
        if(page == null || size == null) {
            throw new RuntimeException("URL Parameter fehlen");
        }
        return this.seasonService.findAllPaginated(page, size);
    }

    @GetMapping("/foo")
    public void doTheFoo() {
        seasonService.foo();
    }
}
