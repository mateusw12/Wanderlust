package com.wanderlust.wanderlust.repository.bookingHotel;

import com.wanderlust.wanderlust.model.bookingHotel.BookingHotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingHotelRepository extends JpaRepository<BookingHotelModel, Long> {
}
