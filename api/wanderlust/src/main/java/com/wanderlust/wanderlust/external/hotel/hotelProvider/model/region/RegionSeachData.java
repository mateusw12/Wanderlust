package com.wanderlust.wanderlust.external.hotel.hotelProvider.model.region;

import lombok.Data;

@Data
public class RegionSeachData {

    private String index;
    private String gaiaId;
    private String type;
    private RegionSearchName regionNames;
    private RegionSearchEssId essId;
    private RegionSearchCoordinates coordinates;
    private RegionSearchHierarchyInfo hierarchyInfo;
}
