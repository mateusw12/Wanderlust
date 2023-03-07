package com.wanderlust.wanderlust.dto.bookingAirport;

import com.wanderlust.wanderlust.model.paymentCondition.PaymentCondition;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record BookingAirportDTO(
        @Id Long id,
        @NotNull @NotBlank @Length(max = 200) String bookingId,
        @NotNull @NotBlank @Length(max = 200) String airportId,
        @NotNull @NotBlank @Length(max = 200) String originCity,
        @NotNull @NotBlank @Length(max = 200) String destinationCity,
        @NotNull Double price,
        @NotNull Date originDate,
        @NotNull Date destinationDate,
        @NotNull Double adultsNumber,
        @NotNull Double childrenNumber,
        @NotNull PaymentCondition paymentCondition,
        @NotNull Boolean isPayment,
        @NotNull @NotBlank String user,
        @NotNull Date bookingDate
) {
}
