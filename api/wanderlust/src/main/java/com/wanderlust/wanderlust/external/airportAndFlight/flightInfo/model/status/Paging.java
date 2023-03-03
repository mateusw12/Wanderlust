package com.wanderlust.wanderlust.external.airportAndFlight.flightInfo.model.status;

import lombok.Data;

@Data
public class Paging {

    private int totalCount;
    private int totalPages;
    private String next;

}
