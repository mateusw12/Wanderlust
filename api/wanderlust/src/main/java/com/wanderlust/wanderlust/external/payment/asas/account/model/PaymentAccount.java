package com.wanderlust.wanderlust.external.payment.asas.account.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;

@Data
public class PaymentAccount {

    @NotBlank
    @NotNull
    private String identificationField;

    @NotNull
    private Date scheduleDate;

    private String description;

    @PositiveOrZero
    private Double discount;

    @NotNull
    private Date dueDate;

    @NotNull
    @PositiveOrZero
    private Double value;

}
