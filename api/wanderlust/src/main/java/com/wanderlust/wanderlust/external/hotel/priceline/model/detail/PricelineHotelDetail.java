package com.wanderlust.wanderlust.external.hotel.priceline.model.detail;

import com.wanderlust.wanderlust.external.hotel.priceline.model.detail.image.PricelineHotelDetailImage;
import com.wanderlust.wanderlust.external.hotel.priceline.model.detail.location.PricelineHotelDetailLocation;
import com.wanderlust.wanderlust.external.hotel.priceline.model.detail.policies.PricelineHOtelDetailPolicies;
import com.wanderlust.wanderlust.external.hotel.priceline.model.detail.reviewRating.PricelineHotelDetailRewiewRating;
import lombok.Data;

import java.util.List;

@Data
public class PricelineHotelDetail {

    private String hotelId;
    private String name;
    private String brand;
    private String brandId;
    private String description;
    private Long starRating;
    private Long propertyTypeId;
    private PricelineHotelDetailLocation location;
    private List<PricelineHotelDetailImage> images;
    private String thumbnailUrl;
    private PricelineHOtelDetailPolicies policies;
    private Double overallGuestRating;
    private Long totalReviewCount;
    private String guestReviewGdsName;
    private PricelineHotelDetailRewiewRating reviewRatingSummary;
    private String chainCode;
    private Boolean allInclusiveRateProperty;
    private Boolean recentlyViewed;
    private Boolean dealUnwrapable;

}
