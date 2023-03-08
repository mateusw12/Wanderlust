package com.wanderlust.wanderlust.controller.bookingAirport;

import com.wanderlust.wanderlust.dto.bookingAirport.BookingAirportDTO;
import com.wanderlust.wanderlust.service.bookingAirport.BookingAirportService;
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
@RequestMapping("api/reserva-passagem-aerea")
@Tag(name = "Reserva de passagem aerea")
public class BookingAirportController {

    @Autowired
    private BookingAirportService bookingAirportService;

    @GetMapping
    @Operation(summary = "Consulta todas os reserva de passagem aerea")
    public @ResponseBody List<BookingAirportDTO> findAll() {
        return bookingAirportService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta reserva de passagem aerea por código")
    public BookingAirportDTO findById(@PathVariable @NotNull @Positive Long id) {
        return bookingAirportService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cadastra uma reserva de passagem aerea")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookingAirportDTO create(@RequestBody @Valid @NotNull BookingAirportDTO bookingAirportDTO) {
        return bookingAirportService.create(bookingAirportDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma reserva de passagem aerea")
    public BookingAirportDTO update(@PathVariable @NotNull @Positive Long id,
                                    @RequestBody @Valid @NotNull BookingAirportDTO bookingAirportDTO) {
        return bookingAirportService.update(id, bookingAirportDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma reserva de passagem aerea")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        bookingAirportService.delete(id);
    }

}
