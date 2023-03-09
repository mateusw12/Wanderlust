package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.response;

import lombok.Data;

import java.util.Date;

@Data
public class BankChargerResponseDiscount {

    private Double value;
    private Date limitDate;
    private Long dueDateLimitDays;
    private String type;

}
