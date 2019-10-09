package com.currencyconverter.microservices.currencyexchangeservice.controller;

import com.currencyconverter.microservices.currencyexchangeservice.model.ExchangeValue;
import com.currencyconverter.microservices.currencyexchangeservice.service.ExchangeValueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    Environment environment;
    @Autowired
    ExchangeValueService exchangeValueService;

    @GetMapping("/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from,
                                               @PathVariable String to) {
        ExchangeValue exchangeValue = exchangeValueService.getExchangeValue(from, to);
        Integer port = Integer.valueOf(environment.getProperty("local.server.port"));
        exchangeValue.setPort(port);
        return exchangeValue;
    }

}
