package com.wanderlust.wanderlust.external.flightInfo.model.status;

import lombok.Data;

import java.util.List;

@Data
public class FlightInfo {

    private CarrierCode carrierCode;
    private String serviceSuffix;
    private int flightNumber;
    private int sequenceNumber;
    private DepartureInfo departure;
    private ArrivalInfo arrival;
    private AircraftType aircraftType;
    private ServiceTypeCode serviceTypeCode;
    private SegmentInfo segmentInfo;
    private String oagFingerprint;
    private CodeshareInfo codeshare;
    private List<StatusDetail> statusDetails;

}
