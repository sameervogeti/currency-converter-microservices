package com.currencyconverter.microservices.currencyconversionservice.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CurrencyConversionBean {
    private long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private Integer quantity;
    private BigDecimal totalCalculatedAmount;
    private Integer port;

}
