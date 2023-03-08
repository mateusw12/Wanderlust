package com.wanderlust.wanderlust.controller.bookingRentalCar;

import com.wanderlust.wanderlust.dto.bookingRentalCar.BookingRentalCarDTO;
import com.wanderlust.wanderlust.service.bookinRentalCar.BookingRentalCarService;
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
@RequestMapping("api/reserva-aluguel-carro")
@Tag(name = "Reserva de aluguel de carro")
public class BookingRentalCarController {

    @Autowired
    private BookingRentalCarService bookingRentalCarService;

    @GetMapping
    @Operation(summary = "Consulta todas os reserva de passagem aerea")
    public @ResponseBody List<BookingRentalCarDTO> findAll() {
        return bookingRentalCarService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta reserva de passagem aerea por código")
    public BookingRentalCarDTO findById(@PathVariable @NotNull @Positive Long id) {
        return bookingRentalCarService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Cadastra uma reserva de passagem aerea")
    @ResponseStatus(code = HttpStatus.CREATED)
    public BookingRentalCarDTO create(@RequestBody @Valid @NotNull BookingRentalCarDTO bookingRentalCarDTO) {
        return bookingRentalCarService.create(bookingRentalCarDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma reserva de passagem aerea")
    public BookingRentalCarDTO update(@PathVariable @NotNull @Positive Long id,
                                      @RequestBody @Valid @NotNull BookingRentalCarDTO bookingRentalCarDTO) {
        return bookingRentalCarService.update(id, bookingRentalCarDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui uma reserva de passagem aerea")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        bookingRentalCarService.delete(id);
    }

}
