package com.example.githubactionstut.Car.repository;

import com.example.githubactionstut.Car.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

@DataMongoTest
@EnableReactiveMongoRepositories
@ActiveProfiles("test")
@AutoConfigureDataMongo
@Slf4j
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private Environment environment;

    @BeforeEach
    void setUp() {

        String databaseName = environment.getProperty("spring.data.mongodb.database");

        Car merc0 = new Car(1025, "Mercedes-AMG F1 W11 EQ Performance");
        Car merc1 = new Car(1050, "Mercedes W12");
        Car merc2 = new Car(1070, "Mercedes W13");

        Car rb0 = new Car(900, "Red Bull Racing RB16");
        Car rb1 = new Car(740, "Red Bull Racing RB18");

        Car ferrari0 = new Car(-1, "Ferrari SF1000");
        Car ferrari1 = new Car(-1, "Ferrari SF21");
        Car ferrari2 = new Car(-1, "Ferrari 065/6");

        Car renault0 = new Car(950, "Alpine A521");
        Car renault1 = new Car(950, "Alpine A522");

        //carRepository.saveAll(Arrays.asList(merc0, merc1, merc2, rb0, rb1, ferrari0, ferrari1, ferrari2, renault0, renault1));
        carRepository.save(merc0);
    }

    @AfterEach
    void tearDown() {
        //carRepository.deleteAll();
    }

    @Test
    public void testSave() {

        Car merc0 = new Car(1025, "Mercedes-AMG F1 W11 EQ Performance");
        Car merc1 = new Car(1050, "Mercedes W12");
        Car merc2 = new Car(1070, "Mercedes W13");

        Flux<Car> cars = carRepository.saveAll(Arrays.asList(merc0, merc1, merc2));

        Flux<Car> saved = Flux.just(merc0, merc1, merc2);


        StepVerifier
                .create(cars)
                .expectNext(saved.next().block())
                .expectNext(saved.next().block())
                .expectNext(saved.next().block())
                .expectComplete();
    }
}