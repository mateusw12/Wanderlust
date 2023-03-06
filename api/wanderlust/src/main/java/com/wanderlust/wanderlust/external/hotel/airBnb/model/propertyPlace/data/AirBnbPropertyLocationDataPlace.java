package com.wanderlust.wanderlust.external.hotel.airBnb.model.propertyPlace.data;

import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.data.AirBnbPropertyContextPageInfo;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.image.AirBnbPropertyImage;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.locationMap.AirBnbPropertyMapLocation;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.property.verified.AirBnbPropertyVerified;
import com.wanderlust.wanderlust.external.hotel.airBnb.model.propertyPlace.preview.AirBnbPropertyPreview;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class AirBnbPropertyLocationDataPlace {

    private Double avgRating;
    private String listingBathroomLabel;
    private Long bathrooms;
    private String listingBedLabel;
    private Long bedrooms;
    private Long beds;
    private String businessHostLabel;
    private String city;
    private String configurableContent;
    private AirBnbPropertyContextPageInfo contextualPicturesPageInfo;
    private List<AirBnbPropertyPreview> listingPreviewAmenityNames;
    private String emergencyMessage;
    private String listingFloatingMessage;
    private String listingGuestLabel;
    private String id;
    private Boolean isAutoTranslated;
    private Boolean isNewListing;
    private Boolean isSuperhost;
    private String relaxedFilterLabels;
    private String localizedCityName;
    private String localizedDistanceText;
    private String locationTitle;
    private String locationContext;
    private String listingName;
    private String listingObjType;
    private String neighborhood;
    private String publicAddress;
    private String richKickers;
    private String roomType;
    private String roomTypeCategory;
    private Long roomTypeId;
    private String spaceType;
    private Long starRating;
    private String summary;
    private Long wishlistedCount;
    private String title;
    private String avgRatingLocalized;
    private String accessibilityLabel;
    private Boolean concatQualifierLeft;
    private String price;
    private Boolean qualifier;
    private Long adults;
    private Long children;
    private Long infants;
    private Date checkin;
    private Date checkout;
    private String categoryTag;
    private Long pets;
    private AirBnbPropertyMapLocation location;
    private AirBnbPropertyVerified verified;
    private List<AirBnbPropertyImage> images;

}
