package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.price;

import lombok.Data;

@Data
public class HotelProviderPrice {

    private String strikeOutType;
    private HotelProviderPriceMessage priceMessages;
    private HotelProviderLead lead;
}
