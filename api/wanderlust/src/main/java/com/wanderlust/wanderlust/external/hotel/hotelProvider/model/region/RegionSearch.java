package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.region;

import lombok.Data;

import java.util.List;

@Data
public class RegionSearch {

    private String query;
    private List<RegionSeachData> data;

}
