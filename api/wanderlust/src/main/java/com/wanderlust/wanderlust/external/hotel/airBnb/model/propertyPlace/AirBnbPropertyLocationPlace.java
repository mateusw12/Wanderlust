package com.wanderlust.wanderlust.external.hotel.airBnb.model.propertyPlace;

import com.wanderlust.wanderlust.external.hotel.airBnb.model.propertyPlace.data.AirBnbPropertyLocationDataPlace;
import lombok.Data;

import java.util.List;

@Data
public class AirBnbPropertyLocationPlace {

    private boolean status;
    private String message;
    private long timestamp;
    private List<AirBnbPropertyLocationDataPlace> data;

}
