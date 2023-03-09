package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.creditCard;

import com.wanderlust.wanderlust.customDecorator.date.futureYear.FutureYear;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BankChargerCreditCardData {

    @NotNull
    @NotBlank
    private String holderName;

    @NotNull
    @NotBlank
    private String number;

    @NotNull
    @NotBlank
    @Max(12)
    private String expiryMonth;

    @NotNull
    @FutureYear
    private String expiryYear;

    @NotNull
    @NotBlank
    private String ccv;

}
