package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.chargerInstallments;

import com.wanderlust.wanderlust.validator.user.decorator.futureDate.FutureDate;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
public class ChargerInstallments {

    @NotBlank
    @NotNull
    private String customer;

    @NotBlank
    @NotNull
    private String billingType;

    @NotNull
    @Positive
    private Long installmentCount;

    @NotNull
    @Positive
    private Long installmentValue;

    @NotNull
    @Positive
    private Double totalValue;

    @NotBlank
    @FutureDate
    private Date dueDate;

    @NotBlank
    @NotNull
    private String description;

    @NotBlank
    @NotNull
    private String externalReference;

    private ChargerInstallmentsDiscount discount;

}
