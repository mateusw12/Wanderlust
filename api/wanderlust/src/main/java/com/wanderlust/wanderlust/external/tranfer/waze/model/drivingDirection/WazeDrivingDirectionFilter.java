package com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection;

import lombok.Data;

@Data
public class WazeDrivingDirectionFilter {

    private String source_coordinates;
    private String destination_coordinates;

}
