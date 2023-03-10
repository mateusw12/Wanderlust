package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.creditCard;

import com.wanderlust.wanderlust.validator.decorator.futureYear.FutureYear;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
    @Length(max = 19)
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
    @Length(max = 3)
    private String ccv;

}
