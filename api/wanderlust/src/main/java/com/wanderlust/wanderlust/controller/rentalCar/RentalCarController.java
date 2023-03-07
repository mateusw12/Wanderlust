package com.wanderlust.wanderlust.controller.rentalCar;

import com.wanderlust.wanderlust.external.carRental.booking.BookingRentalCarService;
import com.wanderlust.wanderlust.external.carRental.booking.model.BookingRentalCar;
import com.wanderlust.wanderlust.external.carRental.carData.CarDataService;
import com.wanderlust.wanderlust.external.carRental.carData.model.CarData;
import com.wanderlust.wanderlust.external.carRental.carData.model.CarDataFilter;
import com.wanderlust.wanderlust.external.carRental.priceline.PricelineService;
import com.wanderlust.wanderlust.external.carRental.priceline.model.searchCars.PricelineSearchCars;
import com.wanderlust.wanderlust.external.carRental.skyscanner.SkyscannerService;
import com.wanderlust.wanderlust.external.carRental.skyscanner.model.SkyscannerSearchLocation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/aluguel-carro")
@Tag(name = "Consulta de alguel de carro")
public class RentalCarController {

    @Autowired
    private BookingRentalCarService bookingRentalCarService;

    @Autowired
    private CarDataService carDataService;

    @Autowired
    private SkyscannerService skyscannerService;

    @Autowired
    private PricelineService pricelineService;

    @GetMapping("/booking/rental-car/{cityName}")
    @Operation(summary = "Consulta carros para aluguel por cidade")
    public List<BookingRentalCar> findRentalCarByCityName(@PathVariable @NotNull @NotBlank String cityName) {
        return bookingRentalCarService.findRentalCarByCityName(cityName);
    }

    @PostMapping("/car-data/filter")
    @Operation(summary = "Consulta carros com filtros")
    public List<CarData> findCarsByFilter(@RequestBody @NotNull @NotBlank CarDataFilter filter) {
        return carDataService.findCarsByFilter(filter);
    }

    @GetMapping("/skyscanner/search-location/{cityName}")
    @Operation(summary = "Consulta locadoras para aluguel de carros por cidade")
    public SkyscannerSearchLocation findSearchLocationCar(@PathVariable @NotNull @NotBlank String cityName) {
        return skyscannerService.findSearchLocationCar(cityName);
    }

    @GetMapping("/priceline/search-cars/{cityName}")
    @Operation(summary = "Consulta locadoras para aluguel de carros por cidade")
    public List<PricelineSearchCars> findSearchLocationCars(@PathVariable @NotNull @NotBlank String cityName) {
        return pricelineService.findSearchLocationCars(cityName);
    }

}
