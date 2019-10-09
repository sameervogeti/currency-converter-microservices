package com.currencyconverter.microservices.currencyexchangeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExchangeValue {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
}
