package com.wanderlust.wanderlust.external.hotel.booking.model.search;

import lombok.Data;

import java.util.Date;

@Data
public class BookingHotelSearchFIlter {

    private Long roomNumber;
    private Date checkoutDate;
    private BookingDestinationType destinationType;
    private Long destinationId;
    private Long adultsNumber;
    private Date checkinDate;
    private BookingOrderBy orderBy;

}
