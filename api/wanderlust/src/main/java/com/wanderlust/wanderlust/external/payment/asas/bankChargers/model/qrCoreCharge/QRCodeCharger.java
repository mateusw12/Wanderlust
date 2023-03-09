package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.qrCoreCharge;

import lombok.Data;

import java.util.Date;

@Data
public class QRCodeCharger {

    private Boolean status;
    private String encodedImage;
    private String payload;
    private Date expirationDate;
}
