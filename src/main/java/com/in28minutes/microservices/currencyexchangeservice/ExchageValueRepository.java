package com.in28minutes.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchageValueRepository extends JpaRepository<ExchageValue, Long> {

    ExchageValue findByFromAndTo(String from, String to);
}
