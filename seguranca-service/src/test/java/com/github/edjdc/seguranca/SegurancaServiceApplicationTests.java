package com.github.edjdc.seguranca;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
    "spring.cloud.config.enabled=false",
    "eureka.client.enabled=false",
    "app.security.enabled=false",
    "app.scheduling.enabled=false",
    "spring.task.scheduling.enabled=false"
})
class SegurancaServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}
