package com.wanderlust.wanderlust.external.flightInfo.model.status;

import lombok.Data;

@Data
public class Time {

    private String dateTime;
    private String timeZone;
    private String iso8601;

}
