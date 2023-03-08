package com.wanderlust.wanderlust.dto.bookingHotel;

import com.wanderlust.wanderlust.model.paymentCondition.PaymentCondition;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record BookingHotelDTO(
        @Id Long id,
        @NotNull @NotBlank @Length(max = 200) String bookingId,
        @NotNull @NotBlank @Length(max = 200) String hotelId,
        @NotNull @NotBlank @Length(max = 200) String city,
        @NotNull Double price,
        @NotNull Date startDate,
        @NotNull Date endDate,
        @NotNull Double adultsNumber,
        @NotNull Double childrenNumber,
        @NotNull PaymentCondition paymentCondition,
        @NotNull Boolean isPayment,
        @NotNull @NotBlank String user,
        @NotNull Date bookingDate,
        @NotNull @NotBlank @Length(max = 200) String agency
) {
}
