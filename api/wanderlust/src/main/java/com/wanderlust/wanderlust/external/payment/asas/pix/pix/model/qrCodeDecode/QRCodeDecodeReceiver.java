package com.wanderlust.wanderlust.external.payment.asas.pix.pix.model.qrCodeDecode;

import lombok.Data;

@Data
public class QRCodeDecodeReceiver {

    private Long ispb;
    private String ispbName;
    private String name;
    private String tradingName;
    private String cpfCnpj;
    private String personType;
    private String agency;
    private String account;
    private String accountType;

}
