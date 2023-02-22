package com.bankapp.dto.response;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Value
public class AccountResponse {

    UUID id;

    String accountNumber;

    UUID clientId;

    String currencyCode;

    BigDecimal currentBalance;

    LocalDate openDate;

    LocalDate closeDate;

    boolean active;
}
