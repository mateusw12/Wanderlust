package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary;

import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.cleanLiness.HotelProdiverPropertyContent;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.overview.HotelProdiverSummaryDetail;
import com.wanderlust.wanderlust.external.hotel.hotelProvider.model.summary.propertyGallery.HotelProviderPropertyGallery;
import lombok.Data;

@Data
public class HotelProviderSummary {

    private HotelProdiverSummaryDetail summary;
    private HotelProviderPropertyGallery propertyGallery;
    private HotelProdiverPropertyContent propertyContentSectionGroups;

}
