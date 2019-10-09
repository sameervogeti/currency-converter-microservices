package com.currencyconverter.microservices.currencyconversionservice.controller;

import com.currencyconverter.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency-converter")
public class CurrencyConverterController {

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean fromCurrencytoCurrency(@PathVariable String from,
                                                         @PathVariable String to,
                                                         @PathVariable Integer quantity) {
        return CurrencyConversionBean.builder()
                .conversionMultiple(new BigDecimal(10))
                .totalCalculatedAmount(new BigDecimal(100))
                .from(from)
                .to(to)
                .quantity(quantity)
                .id(1)
                .build();
    }
}
