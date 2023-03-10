package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger;

import com.wanderlust.wanderlust.validator.decorator.futureDate.FutureDate;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Data
public class BankCharger {

    @NotBlank
    @NotNull
    private String customer;

    @NotBlank
    @NotNull
    private String billingType;

    @NotNull
    @FutureDate
    private Date dueDate;

    @NotNull
    @PositiveOrZero
    private Double value;

    @NotBlank
    @NotNull
    private String description;

    @NotBlank
    @NotNull
    private String externalReference;

    private BankChargerDiscount discount;

    private BankChargerFine fine;

    private BankChargerInterest interest;

    private Boolean postalService;

}
