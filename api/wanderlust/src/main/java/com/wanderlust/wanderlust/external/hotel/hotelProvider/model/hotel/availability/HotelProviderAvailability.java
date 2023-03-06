package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.availability;

import lombok.Data;

@Data
public class HotelProviderAvailability {

    private Boolean available;
    private Long minRoomsLeft;

}
