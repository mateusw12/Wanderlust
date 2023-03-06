package com.wanderlust.wanderlust.external.hotel.airBnb.model.property.data;

import lombok.Data;

@Data
public class AirBnbPropertyContextPageInfo {

    private Boolean hasNextPage;
    private String endCursor;

}
