package com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.model.ted;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class TedBankTransfer {

    @Positive
    @NotNull
    private Double value;

    @NotNull
    private TedBankAccount bankAccount;

    @NotNull
    @NotBlank
    private String operationType;

}
