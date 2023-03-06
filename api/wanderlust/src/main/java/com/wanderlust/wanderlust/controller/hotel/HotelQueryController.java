package com.wanderlust.wanderlust.controller.hotel;

import com.wanderlust.wanderlust.external.hotel.booking.BookingHotelService;
import com.wanderlust.wanderlust.external.hotel.booking.model.data.BookingHotel;
import com.wanderlust.wanderlust.external.hotel.booking.model.description.BookingHotelDescription;
import com.wanderlust.wanderlust.external.hotel.booking.model.image.BookingHotelImage;
import com.wanderlust.wanderlust.external.hotel.booking.model.location.BookingHotelLocation;
import com.wanderlust.wanderlust.external.hotel.booking.model.payment.BookingHotelPayment;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/consulta-hotel")
@Tag(name = "Consulta de hotéis")
public class HotelQueryController {

    @Autowired
    private BookingHotelService bookingHotelService;

    @GetMapping("/location/{cityName}")
    @Operation(summary = "Consulta hotéis por cidade")
    public List<BookingHotelLocation> findHotelsByLocation(@PathVariable @NotNull @NotBlank String cityName) {
        return bookingHotelService.findHotelsByLocation(cityName);
    }

    @GetMapping("/id/{hotelId}")
    @Operation(summary = "Consulta dados do hotel por código")
    public BookingHotel findHotelById(@PathVariable @NotNull @Positive Long hotelId) {
        return bookingHotelService.findHotelById(hotelId);
    }

    @GetMapping("/image/{hotelId}")
    @Operation(summary = "Consulta imagem do hotel por código")
    public List<BookingHotelImage> findImageHotelById(@PathVariable @NotNull @Positive Long hotelId) {
        return bookingHotelService.findImageHotelById(hotelId);
    }

    @GetMapping("/payment/{hotelId}")
    @Operation(summary = "Consulta tipo de pagamento do hotel por código")
    public List<BookingHotelPayment> findPaymentByHotelId(@PathVariable @NotNull @Positive Long hotelId) {
        return bookingHotelService.findPaymentByHotelId(hotelId);
    }

    @GetMapping("/description/{hotelId}")
    @Operation(summary = "Consulta descrição do hotel por código")
    public BookingHotelDescription findDescriptionByHotelId(@PathVariable @NotNull @Positive Long hotelId) {
        return bookingHotelService.findDescriptionByHotelId(hotelId);
    }

}
