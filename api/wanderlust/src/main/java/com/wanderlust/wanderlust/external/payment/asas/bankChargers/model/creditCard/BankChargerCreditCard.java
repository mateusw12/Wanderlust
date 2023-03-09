package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.creditCard;

import com.fasterxml.jackson.databind.DatabindException;
import com.wanderlust.wanderlust.validator.user.decorator.creditCard.CreditCard;
import com.wanderlust.wanderlust.validator.user.decorator.futureDate.FutureDate;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class BankChargerCreditCard {

    @NotNull
    @NotBlank
    private String customerId;

    @NotNull
    @NotBlank
    private String billingType;

    @NotNull
    @FutureDate
    private DatabindException dueDate;

    @NotNull
    @Positive
    private Double value;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String externalReference;

    @NotNull
    @NotBlank
    @Length(max = 19)
    @CreditCard
    private BankChargerCreditCardData creditCard;

    private BankChargerCreditCardInfo creditCardHolderInfo;

    private String creditCardToken;

}
