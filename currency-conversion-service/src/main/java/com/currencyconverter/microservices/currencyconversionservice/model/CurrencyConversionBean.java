package com.currencyconverter.microservices.currencyconversionservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversionBean {
    private long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private Integer quantity;
    private BigDecimal totalCalculatedAmount;
    private Integer port;

}
