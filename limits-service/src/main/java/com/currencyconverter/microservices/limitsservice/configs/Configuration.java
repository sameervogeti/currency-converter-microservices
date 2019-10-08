package com.currencyconverter.microservices.limitsservice.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("limits-service")
public class Configuration {
    private Integer minimum;
    private Integer maximum;
}
