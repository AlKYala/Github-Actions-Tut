package com.example.githubactionstut;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@DataMongoTest
@Slf4j
class GithubActionsTutApplicationTests {

    @Autowired
    private Environment environment;

    @Test
    void contextLoads() {
        String toOverride = environment.getProperty("de.ayalama.variable.to.override");
        log.info(toOverride);
    }

}
