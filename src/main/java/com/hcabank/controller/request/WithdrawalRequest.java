package com.hcabank.controller.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class WithdrawalRequest {
    private String fromAccountNumber;
    private BigDecimal amount;
}
