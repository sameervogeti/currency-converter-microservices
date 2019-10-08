package com.currencyconverter.microservices.limitsservice.controller;

import com.currencyconverter.microservices.limitsservice.configs.Configuration;
import com.currencyconverter.microservices.limitsservice.model.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration config;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsConfiguration()
    {
        return new LimitConfiguration(config.getMaximum(),config.getMinimum());
    }
}
