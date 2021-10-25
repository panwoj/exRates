package com.wpirog.exchangerate.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateResponse {
    private String code;
    private BigDecimal mid;
}
