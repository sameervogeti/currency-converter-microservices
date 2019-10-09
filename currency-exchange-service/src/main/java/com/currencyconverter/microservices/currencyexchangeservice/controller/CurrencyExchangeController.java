package com.currencyconverter.microservices.currencyexchangeservice.controller;

import com.currencyconverter.microservices.currencyexchangeservice.model.ExchangeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from,
                                               @PathVariable("to") String to) {

        Integer port = Integer.valueOf(environment.getProperty("local.server.port"));
        return new ExchangeValue(1l, from, to, new BigDecimal(65), port);
    }

}
