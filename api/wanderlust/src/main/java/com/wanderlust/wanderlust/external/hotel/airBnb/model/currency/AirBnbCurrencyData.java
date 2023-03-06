package com.wanderlust.wanderlust.external.hotel.airBnb.model.currency;

import lombok.Data;

@Data
public class AirBnbCurrencyData {

    private String code;
    private String id;
    private String localizedFullName;
    private String name;
    private String symbol;
    private String unicodeSymbol;
    private boolean isEligibleForGuest;
    private boolean isEligibleForLys;

}
