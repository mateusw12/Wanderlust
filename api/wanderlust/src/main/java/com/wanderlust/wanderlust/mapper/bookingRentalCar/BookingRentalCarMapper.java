package com.wanderlust.wanderlust.mapper.bookingRentalCar;

import com.wanderlust.wanderlust.dto.bookingRentalCar.BookingRentalCarDTO;
import com.wanderlust.wanderlust.model.bookingRentalCar.BookingRentalCarModel;
import com.wanderlust.wanderlust.model.paymentCondition.PaymentCondition;
import org.springframework.stereotype.Component;

@Component
public class BookingRentalCarMapper {

    public BookingRentalCarDTO toDTO(BookingRentalCarModel bookingHotelModel) {
        if (bookingHotelModel == null) {
            return null;
        }
        return new BookingRentalCarDTO(
                bookingHotelModel.getId(),
                bookingHotelModel.getBookingId(),
                bookingHotelModel.getRentalCarId(),
                bookingHotelModel.getCity(),
                bookingHotelModel.getPrice(),
                bookingHotelModel.getStartDate(),
                bookingHotelModel.getEndDate(),
                bookingHotelModel.getAgency(),
                PaymentCondition.getEnumValue(bookingHotelModel.getPaymentCondition()),
                bookingHotelModel.getIsPayment(),
                bookingHotelModel.getUser(),
                bookingHotelModel.getBookingDate()
        );
    }

    public BookingRentalCarModel toEntity(BookingRentalCarDTO bookingRentalCarDTO) {
        if (bookingRentalCarDTO == null) {
            return null;
        }

        BookingRentalCarModel bookingRentalCarModel = new BookingRentalCarModel();
        if (bookingRentalCarDTO.id() != null) {
            bookingRentalCarModel.setId(bookingRentalCarDTO.id());
        }
        bookingRentalCarModel.setRentalCarId(bookingRentalCarDTO.rentalCarId());
        bookingRentalCarModel.setBookingId(bookingRentalCarDTO.bookingId());
        bookingRentalCarModel.setAgency(bookingRentalCarDTO.agency());
        bookingRentalCarModel.setCity(bookingRentalCarDTO.city());
        bookingRentalCarModel.setIsPayment(bookingRentalCarDTO.isPayment());
        bookingRentalCarModel.setStartDate(bookingRentalCarDTO.startDate());
        bookingRentalCarModel.setEndDate(bookingRentalCarDTO.endDate());
        bookingRentalCarModel.setPaymentCondition(bookingRentalCarDTO.paymentCondition().getDescription());
        bookingRentalCarModel.setPrice(bookingRentalCarDTO.price());
        bookingRentalCarModel.setUser(bookingRentalCarDTO.user());
        bookingRentalCarModel.setBookingDate(bookingRentalCarDTO.bookingDate());
        return bookingRentalCarModel;
    }

}
