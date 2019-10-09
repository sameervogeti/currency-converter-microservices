package com.currencyconverter.microservices.currencyconversionservice.controller;

import com.currencyconverter.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.currencyconverter.microservices.currencyconversionservice.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("currency-converter")
@RequiredArgsConstructor
public class CurrencyConverterController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean fromCurrencytoCurrency(@PathVariable String from,
                                                         @PathVariable String to,
                                                         @PathVariable Integer quantity) {
        return currencyExchangeService.getConvertedCurrencyUsingFeign(from, to, quantity);
    }
}
