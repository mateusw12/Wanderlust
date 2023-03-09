package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.reverseCharge;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReverseCharge {

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Double value;

}
