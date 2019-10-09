package com.currencyconverter.microservices.currencyconversionservice.service;

import com.currencyconverter.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @Override
    public CurrencyConversionBean getConvertedCurrency(String from, String to, Integer quantity) {

        Map uriVariables = new HashMap();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> conversionBean = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVariables);
        CurrencyConversionBean currencyConversionBean = conversionBean.getBody();
        return CurrencyConversionBean.builder()
                .totalCalculatedAmount(new BigDecimal(quantity).multiply(currencyConversionBean.getConversionMultiple()))
                .id(currencyConversionBean.getId())
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(currencyConversionBean.getConversionMultiple())
                .port(currencyConversionBean.getPort())
                .build();
    }

    @Override
    public CurrencyConversionBean getConvertedCurrencyUsingFeign(String from, String to, Integer quantity) {
        CurrencyConversionBean currencyConversionBean = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
        return CurrencyConversionBean.builder()
                .totalCalculatedAmount(new BigDecimal(quantity).multiply(currencyConversionBean.getConversionMultiple()))
                .id(currencyConversionBean.getId())
                .from(from)
                .to(to)
                .quantity(quantity)
                .conversionMultiple(currencyConversionBean.getConversionMultiple())
                .port(currencyConversionBean.getPort())
                .build();
    }
}
