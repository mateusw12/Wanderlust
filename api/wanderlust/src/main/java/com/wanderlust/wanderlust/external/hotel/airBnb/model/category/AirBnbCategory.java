package com.wanderlust.wanderlust.external.hotel.airBnb.model.category;

import lombok.Data;

import java.util.List;

@Data
public class AirBnbCategory {

    private Boolean status;
    private String message;
    private Long timestamp;
    private List<AirBnbCategoryDetail> data;
}
