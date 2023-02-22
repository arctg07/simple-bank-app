package com.bankapp.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.util.UUID;

import static com.bankapp.dto.util.OpenApiConstants.CLIENT_ID;
import static com.bankapp.dto.util.OpenApiConstants.CURRENCY_CODE;

@Value
public class AccountRequest {

    @org.hibernate.validator.constraints.UUID
    @Schema(defaultValue = CLIENT_ID)
    UUID clientId;

    @Size(min = 3, max = 3)
    @Schema(defaultValue = CURRENCY_CODE)
    String currencyCode;
}
