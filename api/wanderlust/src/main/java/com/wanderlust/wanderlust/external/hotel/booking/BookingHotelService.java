package com.wanderlust.wanderlust.external.hotel.booking;

import com.wanderlust.wanderlust.external.hotel.booking.model.data.BookingHotel;
import com.wanderlust.wanderlust.external.hotel.booking.model.description.BookingHotelDescription;
import com.wanderlust.wanderlust.external.hotel.booking.model.image.BookingHotelImage;
import com.wanderlust.wanderlust.external.hotel.booking.model.location.BookingHotelLocation;
import com.wanderlust.wanderlust.external.hotel.booking.model.payment.BookingHotelPayment;
import com.wanderlust.wanderlust.external.hotel.booking.model.question.BookingHotelQuestion;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingHotelService {

    private final String apiKey = "5e6bae4b07mshe77f32ea846bc94p149ec3jsn926370fa091c";

    public List<BookingHotelLocation> findHotelsByLocation(String cityName) {
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/hotels/locations?name="+cityName+"&locale=pt-br";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<BookingHotelLocation>> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<BookingHotelLocation>>() {}
        );
        List<BookingHotelLocation> hotelLocations = response.getBody();
        return hotelLocations;
    }

    public BookingHotel findHotelById(Long hotelId) {
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/hotels/data?hotel_id="+hotelId+"&locale=pt-br";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<BookingHotel> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                BookingHotel.class
        );
        BookingHotel bookingHotel = response.getBody();
        return bookingHotel;
    }

    public List<BookingHotelImage> findImageHotelById(Long hotelId) {
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/hotels/photos?locale=en-us&hotel_id="+hotelId+"";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<BookingHotelImage>> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<BookingHotelImage>>() {}
        );
        List<BookingHotelImage> bookingHotelImages = response.getBody();
        return bookingHotelImages;
    }

    public BookingHotel findSerachHotel(Long hotelId) {
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/hotels/data?hotel_id="+hotelId+"&locale=pt-br";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<BookingHotel> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                BookingHotel.class
        );
        BookingHotel bookingHotel = response.getBody();
        return bookingHotel;
    }

    public BookingHotelQuestion findQuestionByHotelId(Long hotelId) {
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/hotels/questions?locale=en-gb&hotel_id="+hotelId;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<BookingHotelQuestion> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                BookingHotelQuestion.class
        );
        BookingHotelQuestion bookingHotelQuestion = response.getBody();
        return bookingHotelQuestion;
    }

    public BookingHotelDescription findDescriptionByHotelId(Long hotelId) {
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/hotels/description?locale=pt-br&hotel_id=="+hotelId;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<BookingHotelDescription> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                BookingHotelDescription.class
        );
        BookingHotelDescription bookingHotelDescription = response.getBody();
        return bookingHotelDescription;
    }

    public List<BookingHotelPayment> findPaymentByHotelId(Long hotelId) {
        String apiUrl = "https://booking-com.p.rapidapi.com/v1/hotels/payment-features?hotel_id="+hotelId+"&locale=en-gb";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "booking-com.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<List<BookingHotelPayment>> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<BookingHotelPayment>>() {}
        );
        List<BookingHotelPayment> bookingHotelPayments = response.getBody();
        return bookingHotelPayments;
    }

}
