package com.wanderlust.wanderlust.dto.bookingRentalCar;

import com.wanderlust.wanderlust.model.paymentCondition.PaymentCondition;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record BookingRentalCarDTO(
        @Id Long id,
        @NotNull @NotBlank @Length(max = 200) String bookingId,
        @NotNull @NotBlank @Length(max = 200) String rentalCarId,
        @NotNull @NotBlank @Length(max = 200) String city,
        @NotNull Double price,
        @NotNull Date startDate,
        @NotNull Date endDate,
        @NotNull @NotBlank @Length(max = 200) String agency,
        @NotNull PaymentCondition paymentCondition,
        @NotNull Boolean isPayment,
        @NotNull @NotBlank String user,
        @NotNull Date bookingDate
) {
}
