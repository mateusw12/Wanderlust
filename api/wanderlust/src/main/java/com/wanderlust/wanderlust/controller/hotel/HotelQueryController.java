package com.wanderlust.wanderlust.controller.hotel;

import com.wanderlust.wanderlust.external.hotel.airBnb.AirBnbService;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.category.AirBnbCategory;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.language.AirBnbLanguage;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.currency.AirBnbCurrency;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.destination.AirBnbLocation;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.AirBnbPropertyFilter;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.AirBnbPropertyLocation;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.propertyPlace.AirBnbPropertyLocationPlace;
import com.wanderlust.wanderlust.external.hotel.booking.BookingHotelService;
import com.wanderlust.wanderlust.external.hotel.booking.model.data.BookingHotel;
import com.wanderlust.wanderlust.external.hotel.booking.model.description.BookingHotelDescription;
import com.wanderlust.wanderlust.external.hotel.booking.model.image.BookingHotelImage;
import com.wanderlust.wanderlust.external.hotel.booking.model.location.BookingHotelLocation;
import com.wanderlust.wanderlust.external.hotel.booking.model.payment.BookingHotelPayment;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.HotelProviderService;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.HotelProviderReviewListFilter;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.HotelProviderSearch;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.filter.HotelProviderSearchFilter;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.region.RegionSearch;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.HotelProviderReviewList;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.HotelProviderReviewScore;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.HotelProviderReviewScoreFilter;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.HotelProviderSummary;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.HotelProviderSummaryFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private AirBnbService airBnbService;

    @Autowired
    private HotelProviderService hotelProviderService;

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

    @GetMapping("/airbnb/destination/{cityName}/{country}")
    @Operation(summary = "Consulta destinos por cidade e país")
    public AirBnbLocation findSearchDestination(@PathVariable @NotNull @NotBlank String cityName,
                                                @PathVariable String country) {
        return airBnbService.findSearchDestination(cityName, country);
    }

    @PostMapping("/airbnb/property")
    @Operation(summary = "Consulta hotel por filtro")
    public AirBnbPropertyLocation findSearchProperty(@RequestBody @NotNull AirBnbPropertyFilter filter) {
        return airBnbService.findSearchProperty(filter);
    }

    @PostMapping("/airbnb/property-place")
    @Operation(summary = "Consulta hotel e lugar por filtro")
    public AirBnbPropertyLocationPlace findSearchPropertyPlace(@RequestBody @NotNull AirBnbPropertyFilter filter) {
        return airBnbService.findSearchPropertyPlace(filter);
    }

    @GetMapping("/airbnb/language")
    @Operation(summary = "Consulta idioma de hoteis do air bnb")
    public AirBnbLanguage findLanguage() {
        return airBnbService.findLanguage();
    }

    @GetMapping("/airbnb/currency")
    @Operation(summary = "Consulta moedas de hoteis do air bnb")
    public AirBnbCurrency findCurrency() {
        return airBnbService.findCurrency();
    }

    @GetMapping("/airbnb/category")
    @Operation(summary = "Consulta categorias de hoteis do air bnb")
    public AirBnbCategory findCategory() {
        return airBnbService.findCategory();
    }

    @GetMapping("/hotel-provider/region/{cityName}/{country}")
    @Operation(summary = "Consulta regiões de hoteis")
    public RegionSearch findRegionSearch(@PathVariable @NotNull @NotBlank String cityName,
                                         @PathVariable @NotNull @NotBlank String country) {
        return hotelProviderService.findRegionSearch(cityName, country);
    }

    @PostMapping("/hotel-provider/hotel-search")
    @Operation(summary = "Consulta hoteis com filtro")
    public HotelProviderSearch findHotelSearch(@RequestBody @NotNull HotelProviderSearchFilter filter) {
        return hotelProviderService.findHotelSearch(filter);
    }

    @PostMapping("/hotel-provider/score")
    @Operation(summary = "Consulta score do hotel com filtro")
    public HotelProviderReviewScore findReviewScore(@RequestBody @NotNull HotelProviderReviewScoreFilter filter) {
        return hotelProviderService.findReviewScore(filter);
    }

    @PostMapping("/hotel-provider/review-list")
    @Operation(summary = "Consulta lista de revisões do hotel com filtro")
    public HotelProviderReviewList findReviewList(@RequestBody @NotNull HotelProviderReviewListFilter filter) {
        return hotelProviderService.findReviewList(filter);
    }

    @PostMapping("/hotel-provider/summary")
    @Operation(summary = "Consulta lista de sumário do hotel com filtro")
    public HotelProviderSummary findHotelSummary(@RequestBody @NotNull HotelProviderSummaryFilter filter) {
        return hotelProviderService.findHotelSummary(filter);
    }

}
