package com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.jams;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WazeJams {

    private String jam_id;
    private String type;
    private Long level;
    private String severity;
    private List<WazeJamsLineCoordinates> line_coordinates;
    private String start_location;
    private String end_location;
    private Double speed_kmh;
    private Double length_meters;
    private Double delay_seconds;
    private String block_alert_id;
    private String block_alert_type;
    private String block_alert_description;
    private Date block_alert_update_datetime_utc;
    private Date block_start_datetime_utc;
    private Date publish_datetime_utc;
    private Date update_datetime_utc;
    private String country;
    private String city;
    private String street;

}
