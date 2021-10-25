package com.wpirog.exchangerate.service;

import com.wpirog.exchangerate.domain.ExchangeRatesSeries;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class RateService {
    private static final String BASE_URL = "http://api.nbp.pl/api/exchangerates/rates/A/";

    public Optional<ExchangeRatesSeries> getRate(String currency) {
        if (currency == null) {
            return Optional.empty();
        }
        RestTemplate template = new RestTemplate();
        var url = new StringBuilder().append(BASE_URL).append(currency).toString();
        ExchangeRatesSeries response = template.getForObject(url, ExchangeRatesSeries.class);
        return Optional.ofNullable(response);
    }
}
