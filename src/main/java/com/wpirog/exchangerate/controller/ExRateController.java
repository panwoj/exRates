package com.wpirog.exchangerate.controller;

import com.wpirog.exchangerate.domain.ExchangeRatesSeries;
import com.wpirog.exchangerate.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ExRateController {
    @Autowired
    private RateService service;

    @GetMapping(value = "rate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView getRate(@RequestParam (required = false) String currency) {
        var exchangeRatesSeries = service.getRate(currency);
        if (exchangeRatesSeries.isPresent() && exchangeRatesSeries.get().getRates().size() > 0) {
            var responseObject = new RateResponse(exchangeRatesSeries.orElse(new ExchangeRatesSeries()).getCode(), exchangeRatesSeries.orElse(new ExchangeRatesSeries()).getRates().get(0).getMid());
            return new ModelAndView("index", getParams(responseObject));
        }
        return new ModelAndView("index");
    }

    private Map<String, String> getParams(RateResponse response) {
        var map = new HashMap<String, String>();
        map.put("currency", response.getCode());
        map.put("rate", response.getMid().toString());
        return map;
    }
}
