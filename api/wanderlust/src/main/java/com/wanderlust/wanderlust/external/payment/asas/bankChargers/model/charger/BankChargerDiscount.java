package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger;

import lombok.Data;

@Data
public class BankChargerDiscount {

    private Double value;
    private Long dueDateLimitDays;

}
