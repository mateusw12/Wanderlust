package com.wanderlust.wanderlust.external.hotel.airBnb.model.currency;

import lombok.Data;

import java.util.List;

@Data
public class AirBnbCurrency {

    private boolean status;
    private String message;
    private long timestamp;
    private List<AirBnbCurrencyData> data;

}
