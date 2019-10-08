package com.currencyconverter.microservices.springcloudfconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudfConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudfConfigServerApplication.class, args);
    }

}
