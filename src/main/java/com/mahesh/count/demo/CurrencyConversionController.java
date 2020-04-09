package com.mahesh.count.demo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Currency Coverter", description="Converting the currency")
public class CurrencyConversionController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());


  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  @ApiOperation(value = "Get target currency with quantity", response = CurrencyConversionBean.class)
  public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to,
      @PathVariable BigDecimal quantity) {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);
    logger.info("Test");

    return new CurrencyConversionBean(2L, from, to, new BigDecimal(12), quantity,
        quantity.multiply(new BigDecimal(14)), 34);
  }


}