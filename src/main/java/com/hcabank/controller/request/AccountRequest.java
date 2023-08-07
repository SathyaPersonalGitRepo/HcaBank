package com.hcabank.controller.request;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AccountRequest {
    private String accountNumber;
    private BigDecimal amount;
}
