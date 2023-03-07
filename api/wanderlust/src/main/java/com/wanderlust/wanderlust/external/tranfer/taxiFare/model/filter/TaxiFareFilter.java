package com.wanderlust.wanderlust.external.tranfer.taxiFare.model.filter;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TaxiFareFilter {

    @NotNull
    @NotBlank
    private Double depeartureLat;

    @NotNull
    @NotBlank
    private Double depeartureLon;

    @NotNull
    @NotBlank
    private Double arriveLat;

    @NotNull
    @NotBlank
    private Double arriveLon;

}
