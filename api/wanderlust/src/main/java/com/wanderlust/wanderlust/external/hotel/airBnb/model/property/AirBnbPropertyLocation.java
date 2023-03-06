package com.wanderlust.wanderlust.external.hotel.airBnb.model.property;

import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.data.AirBnbPropertyData;
import lombok.Data;

import java.util.List;

@Data
public class AirBnbPropertyLocation {

    private boolean status;
    private String message;
    private long timestamp;
    private List<AirBnbPropertyData> data;

}
