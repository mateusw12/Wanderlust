package com.wanderlust.wanderlust.mapper.bookingAirport;

import com.wanderlust.wanderlust.dto.bookingAirport.BookingAirportDTO;
import com.wanderlust.wanderlust.model.bookingAirport.BookingAirportModel;
import com.wanderlust.wanderlust.model.paymentCondition.PaymentCondition;
import org.springframework.stereotype.Component;

@Component
public class BookingAirportMapper {

    public BookingAirportDTO toDTO(BookingAirportModel bookingAirportModel) {
        if (bookingAirportModel == null) {
            return null;
        }
        return new BookingAirportDTO(
                bookingAirportModel.getId(),
                bookingAirportModel.getBookingId(),
                bookingAirportModel.getAirportId(),
                bookingAirportModel.getOriginCity(),
                bookingAirportModel.getDestinationCity(),
                bookingAirportModel.getPrice(),
                bookingAirportModel.getOriginDate(),
                bookingAirportModel.getDestinationDate(),
                bookingAirportModel.getAdultsNumber(),
                bookingAirportModel.getChildrenNumber(),
                PaymentCondition.getEnumValue(bookingAirportModel.getPaymentCondition()),
                bookingAirportModel.getIsPayment(),
                bookingAirportModel.getUser(),
                bookingAirportModel.getBookingDate(),
                bookingAirportModel.getAgency(),
                bookingAirportModel.getFlightId()
        );
    }

    public BookingAirportModel toEntity(BookingAirportDTO bookingAirportDTO) {
        if (bookingAirportDTO == null) {
            return null;
        }

        BookingAirportModel bookingAirportModel = new BookingAirportModel();
        if (bookingAirportDTO.id() != null) {
            bookingAirportModel.setId(bookingAirportDTO.id());
        }
        bookingAirportModel.setAdultsNumber(bookingAirportDTO.adultsNumber());
        bookingAirportModel.setAirportId(bookingAirportDTO.airportId());
        bookingAirportModel.setBookingId(bookingAirportDTO.bookingId());
        bookingAirportModel.setChildrenNumber(bookingAirportDTO.childrenNumber());
        bookingAirportModel.setDestinationCity(bookingAirportDTO.destinationCity());
        bookingAirportModel.setDestinationDate(bookingAirportDTO.destinationDate());
        bookingAirportModel.setIsPayment(bookingAirportDTO.isPayment());
        bookingAirportModel.setOriginCity(bookingAirportDTO.originCity());
        bookingAirportModel.setOriginDate(bookingAirportDTO.originDate());
        bookingAirportModel.setPaymentCondition(bookingAirportDTO.paymentCondition().getDescription());
        bookingAirportModel.setPrice(bookingAirportDTO.price());
        bookingAirportModel.setUser(bookingAirportDTO.user());
        bookingAirportModel.setBookingDate(bookingAirportDTO.bookingDate());
        bookingAirportModel.setAgency(bookingAirportDTO.agency());
        bookingAirportModel.setFlightId(bookingAirportDTO.flightId());
        return bookingAirportModel;
    }

}
