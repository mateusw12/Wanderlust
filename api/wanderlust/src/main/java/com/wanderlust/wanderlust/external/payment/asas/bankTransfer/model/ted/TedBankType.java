package com.wanderlust.wanderlust.external.payment.asas.bankTransfer.model.ted;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TedBankType {

    @NotNull
    @NotBlank
    private String code;

}
