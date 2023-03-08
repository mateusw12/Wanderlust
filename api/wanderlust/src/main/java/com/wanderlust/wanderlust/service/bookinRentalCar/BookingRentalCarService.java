package com.wanderlust.wanderlust.service.bookinRentalCar;

import com.wanderlust.wanderlust.dto.bookingRentalCar.BookingRentalCarDTO;
import com.wanderlust.wanderlust.mapper.bookingRentalCar.BookingRentalCarMapper;
import com.wanderlust.wanderlust.model.bookingRentalCar.BookingRentalCarModel;
import com.wanderlust.wanderlust.repository.bookingRentalCar.BookingRentalCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingRentalCarService {

    @Autowired
    private BookingRentalCarRepository bookingRentalCarRepository;

    @Autowired
    private BookingRentalCarMapper bookingRentalCarMapper;

    @Transactional
    public List<BookingRentalCarDTO> findAll() {
        return bookingRentalCarRepository.findAll()
                .stream()
                .map(bookingRentalCarMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public BookingRentalCarDTO findById(Long id) {
        return bookingRentalCarRepository.findById(id).map(bookingRentalCarMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Booking rental car not found" + id));
    }

    @Transactional
    public BookingRentalCarDTO create(BookingRentalCarDTO bookingRentalCarDTO) {
        BookingRentalCarModel bookingRentalCarModel = bookingRentalCarMapper.toEntity(bookingRentalCarDTO);
        return bookingRentalCarMapper.toDTO(bookingRentalCarRepository.save(bookingRentalCarModel));
    }

    @Transactional
    public BookingRentalCarDTO update(Long id, BookingRentalCarDTO bookingRentalCarDTO) {
        BookingRentalCarModel bookingRentalCarModel = bookingRentalCarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking rental car not found" + id));
        if(bookingRentalCarModel.getIsPayment()){
            return bookingRentalCarDTO;
        }
        return bookingRentalCarRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setRentalCarId(bookingRentalCarDTO.rentalCarId());
                    recordFound.setBookingId(bookingRentalCarDTO.bookingId());
                    recordFound.setAgency(bookingRentalCarDTO.agency());
                    recordFound.setCity(bookingRentalCarDTO.city());
                    recordFound.setId(bookingRentalCarDTO.id());
                    recordFound.setIsPayment(bookingRentalCarDTO.isPayment());
                    recordFound.setStartDate(bookingRentalCarDTO.startDate());
                    recordFound.setEndDate(bookingRentalCarDTO.endDate());
                    recordFound.setPaymentCondition(bookingRentalCarDTO.paymentCondition().getDescription());
                    recordFound.setPrice(bookingRentalCarDTO.price());
                    return bookingRentalCarMapper.toDTO(bookingRentalCarRepository.save(recordFound));
                }).orElseThrow(() -> new EntityNotFoundException("Booking rental car not found" + id));
    }

    @Transactional
    public String delete(Long id) {
        BookingRentalCarModel bookingRentalCarModel = bookingRentalCarRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking rental car not found" + id));
        if(bookingRentalCarModel.getIsPayment()){
            bookingRentalCarRepository.deleteById(id);
        }
        return "O aluguel de carro ja teve seu pagamento efetuado!";
    }

}
