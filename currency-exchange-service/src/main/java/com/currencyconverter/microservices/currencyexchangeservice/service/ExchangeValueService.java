package com.currencyconverter.microservices.currencyexchangeservice.service;

import com.currencyconverter.microservices.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueService {
    public ExchangeValue getExchangeValue(String from_value, String to_value);
}
