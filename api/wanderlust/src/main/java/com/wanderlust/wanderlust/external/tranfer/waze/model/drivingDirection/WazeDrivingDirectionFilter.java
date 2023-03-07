package com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WazeDrivingDirectionFilter {

    @NotNull
    @NotBlank
    private String source_coordinates;

    @NotNull
    @NotBlank
    private String destination_coordinates;

}
