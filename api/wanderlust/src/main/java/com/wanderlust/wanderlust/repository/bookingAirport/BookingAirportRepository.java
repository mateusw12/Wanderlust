package com.wanderlust.wanderlust.repository.bookingAirport;

import com.wanderlust.wanderlust.model.bookingAirport.BookingAirportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingAirportRepository extends JpaRepository<BookingAirportModel, Long> {

    BookingAirportModel findByUserAndId(Long id, String user);

}
