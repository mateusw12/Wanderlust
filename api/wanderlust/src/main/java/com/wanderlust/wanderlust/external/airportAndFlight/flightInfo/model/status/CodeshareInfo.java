package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status;

import lombok.Data;

import java.util.List;

@Data
public class CodeshareInfo {

    private OperatingAirlineDisclosure operatingAirlineDisclosure;
    private AircraftOwner aircraftOwner;
    private CockpitCrewEmployer cockpitCrewEmployer;
    private List<JointOperationAirlineDesignator> jointOperationAirlineDesignators;
    private List<Comment010> comments010;
    private Comment050 comment050;

}
