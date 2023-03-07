package com.wanderlust.wanderlust.external.tranfer.taxiFare.model;

import lombok.Data;

import java.util.Date;

@Data
public class TaxiFareHeader {

    private Double response_time;
    private Date response_timestamp;
    private String api;
    private Long response_id;

}
