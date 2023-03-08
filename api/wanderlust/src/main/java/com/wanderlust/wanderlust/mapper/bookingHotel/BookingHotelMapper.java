package com.wanderlust.wanderlust.mapper.bookingHotel;

import com.wanderlust.wanderlust.dto.bookingHotel.BookingHotelDTO;
import com.wanderlust.wanderlust.model.bookingHotel.BookingHotelModel;
import com.wanderlust.wanderlust.model.paymentCondition.PaymentCondition;
import org.springframework.stereotype.Component;

@Component
public class BookingHotelMapper {

    public BookingHotelDTO toDTO(BookingHotelModel bookingHotelModel) {
        if (bookingHotelModel == null) {
            return null;
        }
        return new BookingHotelDTO(
                bookingHotelModel.getId(),
                bookingHotelModel.getBookingId(),
                bookingHotelModel.getHotelId(),
                bookingHotelModel.getCity(),
                bookingHotelModel.getPrice(),
                bookingHotelModel.getStartDate(),
                bookingHotelModel.getEndDate(),
                bookingHotelModel.getAdultsNumber(),
                bookingHotelModel.getChildrenNumber(),
                PaymentCondition.getEnumValue(bookingHotelModel.getPaymentCondition()),
                bookingHotelModel.getIsPayment(),
                bookingHotelModel.getUser(),
                bookingHotelModel.getBookingDate(),
                bookingHotelModel.getAgency()
        );
    }

    public BookingHotelModel toEntity(BookingHotelDTO bookingHotelDTO) {
        if (bookingHotelDTO == null) {
            return null;
        }

        BookingHotelModel bookingHotelModel = new BookingHotelModel();
        if (bookingHotelDTO.id() != null) {
            bookingHotelModel.setId(bookingHotelDTO.id());
        }
        bookingHotelModel.setAdultsNumber(bookingHotelDTO.adultsNumber());
        bookingHotelModel.setHotelId(bookingHotelDTO.hotelId());
        bookingHotelModel.setBookingId(bookingHotelDTO.bookingId());
        bookingHotelModel.setChildrenNumber(bookingHotelDTO.childrenNumber());
        bookingHotelModel.setCity(bookingHotelDTO.city());
        bookingHotelModel.setIsPayment(bookingHotelDTO.isPayment());
        bookingHotelModel.setStartDate(bookingHotelDTO.startDate());
        bookingHotelModel.setEndDate(bookingHotelDTO.endDate());
        bookingHotelModel.setPaymentCondition(bookingHotelDTO.paymentCondition().getDescription());
        bookingHotelModel.setPrice(bookingHotelDTO.price());
        bookingHotelModel.setUser(bookingHotelDTO.user());
        bookingHotelModel.setBookingDate(bookingHotelDTO.bookingDate());
        bookingHotelModel.setAgency(bookingHotelDTO.agency());
        return bookingHotelModel;
    }

}
