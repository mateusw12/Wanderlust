package com.wanderlust.wanderlust.external.hotel.airBnb.model.destination;

import lombok.Data;

import java.util.List;

@Data
public class AirBnbLocation {

    private boolean status;
    private String message;
    private long timestamp;
    private List<AirBnbData> data;

}
