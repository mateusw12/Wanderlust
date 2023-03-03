package com.wanderlust.wanderlust.external.hotel.booking.model.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookingHotelMaxData {

    private Long is_fullon;
    private String experiment;
    private Long default_los;
    private Long extended_los;
    private Long has_extended_los;
    private Long max_allowed_los;

}
