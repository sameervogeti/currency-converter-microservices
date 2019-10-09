package com.currencyconverter.microservices.currencyconversionservice.service;

import com.currencyconverter.microservices.currencyconversionservice.model.CurrencyConversionBean;

public interface CurrencyExchangeService {

    CurrencyConversionBean getConvertedCurrency(String from, String to, Integer quantity);

}
