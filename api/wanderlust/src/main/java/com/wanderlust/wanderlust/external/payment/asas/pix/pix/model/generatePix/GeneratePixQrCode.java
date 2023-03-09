package com.wanderlust.wanderlust.external.payment.asas.pix.pix.model.generatePix;

import lombok.Data;

@Data
public class GeneratePixQrCode {

    private String encodedImage;
    private String payload;
}
