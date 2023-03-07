package com.wanderlust.wanderlust.external.hotel.priceline.model.detail.policies;

import lombok.Data;

import java.util.List;

@Data
public class PricelineHOtelDetailPolicies {

    private String childrenDescription;
    private String petDescription;
    private List<PricelineHotelDetailPolicesImportantInfo> importantInfo;
}
