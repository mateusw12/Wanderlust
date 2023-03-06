package com.wanderlust.wanderlust.external.hotel.airBnb.model.language;

import lombok.Data;

import java.util.List;

@Data
public class AirBnbLanguage {

    private Boolean status;
    private String message;
    private Long timestamp;
    private List<AirBnbLanguageDetail> data;
}
