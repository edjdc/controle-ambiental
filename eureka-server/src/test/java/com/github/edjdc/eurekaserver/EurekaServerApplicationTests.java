package com.github.edjdc.eurekaserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.cloud.config.enabled=false", "app.security.enabled=false"})
class EurekaServerApplicationTests {

    @Test
    void contextLoads() {
    }
}
