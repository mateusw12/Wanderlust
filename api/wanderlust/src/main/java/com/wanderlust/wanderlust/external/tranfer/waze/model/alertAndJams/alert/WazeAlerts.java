package com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.alert;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WazeAlerts {

    private String alert_id;
    private String type;
    private String subtype;
    private Date publish_datetime_utc;
    private String country;
    private String city;
    private String street;
    private Double latitude;
    private Double longitude;
    private Long num_thumbs_up;
    private Long alert_reliability;
    private Long num_comments;
    private List<String> comments;

}
