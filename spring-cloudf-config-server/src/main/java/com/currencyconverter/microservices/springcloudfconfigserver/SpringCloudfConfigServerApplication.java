package com.currencyconverter.microservices.springcloudfconfigserver;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudfConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudfConfigServerApplication.class, args);
    }
    @Bean
    public Sampler defaultSampler()
    {
        return Sampler.ALWAYS_SAMPLE;
    }
}
