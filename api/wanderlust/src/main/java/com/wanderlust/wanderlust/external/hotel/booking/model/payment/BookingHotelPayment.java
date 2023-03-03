package com.wanderlust.wanderlust.external.hotel.booking.model.payment;

import lombok.Data;

@Data
public class BookingHotelPayment {

    private String hotel_id;
    private int bookable;
    private int payable;
    private int is_direct_payment;
    private int cvc_required;
    private int creditcard_id;

}
