package com.wanderlust.wanderlust.repository.bookingRentalCar;

import com.wanderlust.wanderlust.model.bookingRentalCar.BookingRentalCarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRentalCarRepository extends JpaRepository<BookingRentalCarModel, Long> {
}
