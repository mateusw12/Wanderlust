package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.price;

import lombok.Data;

@Data
public class HotelProviderLead {

    private Double amount;
    private String formatted;
    private HotelProviderCurrencyInfo currencyInfo;
}
