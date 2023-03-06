package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList;

import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.review.HotelProviderReviews;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.reviewExpando.HotelProviderReviewExpando;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.reviewLink.HotelProviderReviewlink;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.sortFilter.HotelProviderSortFilter;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.reviewList.summary.HotelProviderSummary;
import lombok.Data;

import java.util.List;

@Data
public class HotelProviderReviewList {

    private String id;
    private List<HotelProviderReviews> reviews;
    private HotelProviderSummary summary;
    private String reviewFlag;
    private HotelProviderReviewlink writeReviewLink;
    private HotelProviderSortFilter sortAndFilter;
    private HotelProviderReviewExpando reviewsExpando;

}
