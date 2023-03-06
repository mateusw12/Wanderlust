package com.wanderlust.wanderlust.external.hotel.booking.model.description;

import lombok.Data;

@Data
public class BookingHotelDescription {

    private String languagecode;
    private Long descriptiontype_id;
    private String description;
    private BookingHotelDescriptionExtra extra_lines;


}
