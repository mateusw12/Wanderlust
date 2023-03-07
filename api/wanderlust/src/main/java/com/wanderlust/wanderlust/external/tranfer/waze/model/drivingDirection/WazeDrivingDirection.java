package com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection;

import lombok.Data;

import java.util.List;

@Data
public class WazeDrivingDirection {

    private String status;
    private String request_id;
    private List<WazeDrivingDirectionData> data;

}
