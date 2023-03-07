package com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection;

import lombok.Data;

@Data
public class WazeDrivingDirectionAlert {

    private String alert_id;
    private String type;
    private String subtype;
    private Double latitude;
    private Double longitude;

}
