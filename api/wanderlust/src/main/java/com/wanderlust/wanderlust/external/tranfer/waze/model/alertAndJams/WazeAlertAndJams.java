package com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams;

import lombok.Data;

@Data
public class WazeAlertAndJams {

    private String status;
    private String request_id;
    private WazeAlertAndJamsData data;

}
