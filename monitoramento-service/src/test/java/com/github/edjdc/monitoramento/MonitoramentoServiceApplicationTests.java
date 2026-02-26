package com.github.edjdc.monitoramento;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"spring.cloud.config.enabled=false", "eureka.client.enabled=false", "app.security.enabled=false"})
class MonitoramentoServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}
