package com.wanderlust.wanderlust.external.hotel.hotelProvider;

import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.HotelProviderReviewListFilter;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.HotelProviderSearch;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.hotel.filter.HotelProviderSearchFilter;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.region.RegionSearch;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.HotelProviderReviewList;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.HotelProviderReviewScore;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewScore.HotelProviderReviewScoreFilter;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.HotelProviderSummary;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.HotelProviderSummaryFilter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelProviderService {

    private final String apiKey = "";

    public RegionSearch findRegionSearch(String cityName, String Country) {
        String cityNameFormat = cityName.replace(" ", "%20");
        String apiUrl = "https://hotels-com-provider.p.rapidapi.com/v2/regions?locale=pt_BR&query="+cityNameFormat+"&domain="+Country;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "hotels-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<RegionSearch> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                RegionSearch.class
        );
        RegionSearch regionSearch = response.getBody();
        return regionSearch;
    }

    public HotelProviderSearch findHotelSearch(HotelProviderSearchFilter filter) {
        String apiUrl = "https://hotels-com-provider.p.rapidapi.com/v2/hotels/search?";

        if(filter.getDomain() != null){
            apiUrl = apiUrl+"domain="+filter.getDomain();
        }

        if(filter.getSortOrder() != null){
            apiUrl = apiUrl+"&sort_order="+filter.getSortOrder().getDescription();
            apiUrl = apiUrl+"&locale=en_GB";
        }

        if(filter.getCheckoutDate() != null){
            apiUrl = apiUrl+ "&checkout_date="+filter.getCheckinDate();
        }

        if(filter.getCheckinDate() != null){
            apiUrl = apiUrl+ "&checkin_date="+filter.getCheckinDate();
        }

        if(filter.getRegionId() > 0){
            apiUrl = apiUrl+"&region_id="+filter.getRegionId();
        }

        if(filter.getAdultsNumber() > 0){
            apiUrl = apiUrl+"&adults_number="+filter.getAdultsNumber();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "hotels-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<HotelProviderSearch> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                HotelProviderSearch.class
        );
        HotelProviderSearch hotelProviderSearch = response.getBody();
        return hotelProviderSearch;
    }

    public HotelProviderReviewList findReviewList(HotelProviderReviewListFilter filter) {
        String apiUrl = "https://hotels-com-provider.p.rapidapi.com/v2/hotels/reviews/list?";

        if(filter.getDomain() != null){
            apiUrl = apiUrl+"domain="+filter.getDomain();
        }

        if(filter.getLocale() != null){
            apiUrl = apiUrl+"&locale=="+filter.getLocale();
        }

        if(filter.getHotelId() > 0){
            apiUrl = apiUrl+"&hotel_id="+filter.getHotelId();
        }

        apiUrl = apiUrl + "&page_number=1";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "hotels-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<HotelProviderReviewList> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                HotelProviderReviewList.class
        );
        HotelProviderReviewList hotelProviderReviewList = response.getBody();
        return hotelProviderReviewList;
    }

    public HotelProviderSummary findHotelSummary(HotelProviderSummaryFilter filter) {
        String apiUrl = "https://hotels-com-provider.p.rapidapi.com/v2/hotels/summary?";

        if(filter.getDomain() != null){
            apiUrl = apiUrl+"domain="+filter.getDomain();
        }

        if(filter.getLocale() != null){
            apiUrl = apiUrl+"&locale=="+filter.getLocale();
        }

        if(filter.getHotelId() > 0){
            apiUrl = apiUrl+"&hotel_id="+filter.getHotelId();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "hotels-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<HotelProviderSummary> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                HotelProviderSummary.class
        );
        HotelProviderSummary hotelProviderSummary = response.getBody();
        return hotelProviderSummary;
    }

    public HotelProviderReviewScore findReviewScore(HotelProviderReviewScoreFilter filter) {
        String apiUrl = "https://hotels-com-provider.p.rapidapi.com/v2/hotels/reviews/scores?";

        if(filter.getDomain() != null){
            apiUrl = apiUrl+"domain="+filter.getDomain();
        }

        if(filter.getHotelId() > 0){
            apiUrl = apiUrl + "&hotel_id="+filter.getHotelId();
        }

        if(filter.getLocale() != null){
            apiUrl = apiUrl + "&locale="+filter.getLocale();
        }

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "hotels-com-provider.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<HotelProviderReviewScore> response;
        response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                HotelProviderReviewScore.class
        );
        HotelProviderReviewScore hotelProviderReviewScore = response.getBody();
        return hotelProviderReviewScore;
    }

}
