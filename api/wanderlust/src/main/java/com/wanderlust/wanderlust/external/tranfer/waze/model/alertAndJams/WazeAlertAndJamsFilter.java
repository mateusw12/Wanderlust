package com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WazeAlertAndJamsFilter {

    @NotNull
    @NotBlank
    private String bottom_left;

    @NotNull
    @NotBlank
    private String top_right;

}
