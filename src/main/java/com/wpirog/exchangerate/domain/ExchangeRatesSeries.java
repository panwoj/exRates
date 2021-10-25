package com.wpirog.exchangerate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRatesSeries {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
}
