package com.in28minutes.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyExchangeController {



    @Autowired
    private Environment environment;
    @Autowired
    private ExchageValueRepository repo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

   @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchageValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
      //  ExchageValue exchageValue=new ExchageValue(1000L,from,to, BigDecimal.valueOf(65));
       ExchageValue exchageValue = repo.findByFromAndTo(from,to);

        exchageValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("excchage value {}", exchageValue);
        return exchageValue;

    }


}
