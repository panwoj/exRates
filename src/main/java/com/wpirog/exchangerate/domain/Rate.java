package com.wpirog.exchangerate.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rate {
    private String no;
    private String effectiveDate;
    private BigDecimal mid;
}
