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
    public BookingHotelDTO create(BookingHotelDTO bookingHotelDTO) {
        BookingHotelModel bookingHotelModel = bookingHotelMapper.toEntity(bookingHotelDTO);
        return bookingHotelMapper.toDTO(bookingHotelRepository.save(bookingHotelModel));
    }

    @Transactional
    public BookingHotelDTO update(Long id, BookingHotelDTO bookingHotelDTO) {
        BookingHotelModel bookingAirportModel = bookingHotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
        if(bookingAirportModel.getIsPayment()){
            return bookingHotelDTO;
        }
        return bookingHotelRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setAdultsNumber(bookingHotelDTO.adultsNumber());
                    recordFound.setHotelId(bookingHotelDTO.hotelId());
                    recordFound.setBookingId(bookingHotelDTO.bookingId());
                    recordFound.setChildrenNumber(bookingHotelDTO.childrenNumber());
                    recordFound.setCity(bookingHotelDTO.city());
                    recordFound.setId(bookingHotelDTO.id());
                    recordFound.setIsPayment(bookingHotelDTO.isPayment());
                    recordFound.setStartDate(bookingHotelDTO.startDate());
                    recordFound.setEndDate(bookingHotelDTO.endDate());
                    recordFound.setPaymentCondition(bookingHotelDTO.paymentCondition().getDescription());
                    recordFound.setPrice(bookingHotelDTO.price());
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
