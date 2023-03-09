package com.wanderlust.wanderlust.external.payment.asas.model.pix.generatePix;

import lombok.Data;

@Data
public class GeneratePixQrCode {

    private String encodedImage;
    private String payload;
}
