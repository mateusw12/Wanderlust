package com.wanderlust.wanderlust.controller.booking;

import com.wanderlust.wanderlust.dto.bookingHotel.BookingHotelDTO;
import com.wanderlust.wanderlust.service.bookingHotel.BookingHotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/reserva-hotel")
@Tag(name = "Reserva de hotel")
public class BookingHotelController {

    @Autowired
    private BookingHotelService bookingHotelService;

    @GetMapping
    @Operation(summary = "Consulta todas os reserva de passagem aerea")
    public @ResponseBody List<BookingHotelDTO> findAll() {
        return bookingHotelService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta reserva de passagem aerea por código")
    public BookingHotelDTO findById(@PathVariable @NotNull @Positive Long id) {
        return bookingHotelService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cadastra uma reserva de passagem aerea")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookingHotelDTO create(@RequestBody @Valid @NotNull BookingHotelDTO bookingHotelDTO) {
        return bookingHotelService.create(bookingHotelDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma reserva de passagem aerea")
    public BookingHotelDTO update(@PathVariable @NotNull @Positive Long id,
                                  @RequestBody @Valid @NotNull BookingHotelDTO bookingHotelDTO) {
        return bookingHotelService.update(id, bookingHotelDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma reserva de passagem aerea")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        bookingHotelService.delete(id);
    }

}
