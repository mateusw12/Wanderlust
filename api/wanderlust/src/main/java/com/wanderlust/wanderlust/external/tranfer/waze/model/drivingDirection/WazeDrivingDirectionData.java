package com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection;

import lombok.Data;

import java.util.List;

@Data
public class WazeDrivingDirectionData {

    private String route_name;
    private Double length_meters;
    private Double duration_seconds;
    private Boolean passes_through_danger_area;
    private Boolean is_toll;
    private Boolean is_hov;
    private Boolean is_fastest;
    private List<WazeDrivingDirectionAlert> alerts;
    private String traffic_label;

}
