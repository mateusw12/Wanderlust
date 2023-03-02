package com.wanderlust.wanderlust.external.flightInfo.model.status;

import lombok.Data;

@Data
public class SegmentInfo {

    private int numberOfStops;
    private IntermediateAirports intermediateAirports;

}
