package com.wanderlust.wanderlust.service.bookingHotel;

import com.wanderlust.wanderlust.dto.bookingHotel.BookingHotelDTO;
import com.wanderlust.wanderlust.mapper.bookingHotel.BookingHotelMapper;
import com.wanderlust.wanderlust.model.bookingHotel.BookingHotelModel;
import com.wanderlust.wanderlust.repository.bookingHotel.BookingHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingHotelService {

    @Autowired
    private BookingHotelRepository bookingHotelRepository;

    @Autowired
    private BookingHotelMapper bookingHotelMapper;

    @Transactional
    public List<BookingHotelDTO> findAll() {
        return bookingHotelRepository.findAll()
                .stream()
                .map(bookingHotelMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingHotelDTO findById(Long id) {
        return bookingHotelRepository.findById(id).map(bookingHotelMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
    }

    @Transactional
    public BookingHotelDTO create(BookingHotelDTO bookingAirportDTO) {
        BookingHotelModel bookingAirportModel = bookingHotelMapper.toEntity(bookingAirportDTO);
        return bookingHotelMapper.toDTO(bookingHotelRepository.save(bookingAirportModel));
    }

    @Transactional
    public BookingHotelDTO update(Long id, BookingHotelDTO bookingAirportDTO) {
        BookingHotelModel bookingAirportModel = bookingHotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
        if(bookingAirportModel.getIsPayment()){
            return bookingAirportDTO;
        }
        return bookingHotelRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setAdultsNumber(bookingAirportDTO.adultsNumber());
                    recordFound.setHotelId(bookingAirportDTO.hotelId());
                    recordFound.setBookingId(bookingAirportDTO.bookingId());
                    recordFound.setChildrenNumber(bookingAirportDTO.childrenNumber());
                    recordFound.setCity(bookingAirportDTO.city());
                    recordFound.setId(bookingAirportDTO.id());
                    recordFound.setIsPayment(bookingAirportDTO.isPayment());
                    recordFound.setStartDate(bookingAirportDTO.startDate());
                    recordFound.setEndDate(bookingAirportDTO.endDate());
                    recordFound.setPaymentCondition(bookingAirportDTO.paymentCondition().getDescription());
                    recordFound.setPrice(bookingAirportDTO.price());
                    return bookingHotelMapper.toDTO(bookingHotelRepository.save(recordFound));
                }).orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
    }

    @Transactional
    public String delete(Long id) {
        BookingHotelModel bookingAirportModel = bookingHotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
        if(bookingAirportModel.getIsPayment()){
            bookingHotelRepository.deleteById(id);
        }
        return "A passagem aerea ja teve seu pagamento efetuado!";
    }

}
