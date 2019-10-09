package com.currencyconverter.microservices.currencyexchangeservice.repository;

import com.currencyconverter.microservices.currencyexchangeservice.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String currency_from, String currency_to);
}
