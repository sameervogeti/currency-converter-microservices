package com.currencyconverter.microservices.currencyexchangeservice.service;

import com.currencyconverter.microservices.currencyexchangeservice.model.ExchangeValue;
import com.currencyconverter.microservices.currencyexchangeservice.repository.ExchangeValueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeValueServiceImpl implements ExchangeValueService {

    @Autowired
    ExchangeValueRepository exchangeValueRepository;

    @Override
    public ExchangeValue getExchangeValue(String from, String to) {

        return exchangeValueRepository.findByFromAndTo(from, to);
    }
}
