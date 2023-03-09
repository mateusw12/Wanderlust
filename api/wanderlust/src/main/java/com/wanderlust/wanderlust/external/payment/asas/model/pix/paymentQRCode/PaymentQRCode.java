package com.wanderlust.wanderlust.external.payment.asas.model.pix.paymentQRCode;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentQRCode {

    private PaymentKey qrCode;
    private Double value;
    private String description;
    private Date scheduleDate;

}
