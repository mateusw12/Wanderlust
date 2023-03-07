package com.wanderlust.wanderlust.service.bookingAirport;

import com.wanderlust.wanderlust.dto.bookingAirport.BookingAirportDTO;
import com.wanderlust.wanderlust.mapper.bookingAirport.BookingAirportMapper;
import com.wanderlust.wanderlust.model.bookingAirport.BookingAirportModel;
import com.wanderlust.wanderlust.repository.bookingAirport.BookingAirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingAirportService {

    @Autowired
    private BookingAirportRepository bookingAirportRepository;

    @Autowired
    private BookingAirportMapper bookingAirportMapper;

    @Transactional
    public List<BookingAirportDTO> findAll() {
        return bookingAirportRepository.findAll()
                .stream()
                .map(bookingAirportMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingAirportDTO findById(Long id) {
        return bookingAirportRepository.findById(id).map(bookingAirportMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
    }

    @Transactional
    public BookingAirportDTO create(BookingAirportDTO bookingAirportDTO) {
        BookingAirportModel bookingAirportModel = bookingAirportMapper.toEntity(bookingAirportDTO);
        return bookingAirportMapper.toDTO(bookingAirportRepository.save(bookingAirportModel));
    }

    @Transactional
    public BookingAirportDTO update(Long id, BookingAirportDTO bookingAirportDTO) {
        BookingAirportModel bookingAirportModel = bookingAirportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
        if(bookingAirportModel.getIsPayment()){
            return bookingAirportDTO;
        }
        return bookingAirportRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setAdultsNumber(bookingAirportDTO.adultsNumber());
                    recordFound.setAirportId(bookingAirportDTO.airportId());
                    recordFound.setBookingId(bookingAirportDTO.bookingId());
                    recordFound.setChildrenNumber(bookingAirportDTO.childrenNumber());
                    recordFound.setDestinationCity(bookingAirportDTO.destinationCity());
                    recordFound.setDestinationDate(bookingAirportDTO.destinationDate());
                    recordFound.setId(bookingAirportDTO.id());
                    recordFound.setIsPayment(bookingAirportDTO.isPayment());
                    recordFound.setOriginCity(bookingAirportDTO.originCity());
                    recordFound.setOriginDate(bookingAirportDTO.originDate());
                    recordFound.setPaymentCondition(bookingAirportDTO.paymentCondition().getDescription());
                    recordFound.setPrice(bookingAirportDTO.price());
                    return bookingAirportMapper.toDTO(bookingAirportRepository.save(recordFound));
                }).orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
    }

    @Transactional
    public String delete(Long id) {
        BookingAirportModel bookingAirportModel = bookingAirportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking airport not found" + id));
       if(bookingAirportModel.getIsPayment()){
           bookingAirportRepository.deleteById(id);
       }
        return "A passagem aerea ja teve seu pagamento efetuado!";
    }

}
