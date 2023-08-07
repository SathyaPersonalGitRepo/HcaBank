package com.hcabank.controller.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class DepositRequest {
    private String toAccountNumber;
    private BigDecimal amount;
}
