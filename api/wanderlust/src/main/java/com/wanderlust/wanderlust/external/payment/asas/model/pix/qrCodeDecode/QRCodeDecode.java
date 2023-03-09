package com.wanderlust.wanderlust.external.payment.asas.model.pix.qrCodeDecode;

import lombok.Data;

import java.util.Date;

@Data
public class QRCodeDecode {

    private String payload;
    private String type;
    private String transactionOriginType;
    private String pixKey;
    private String conciliationIdentifier;
    private String endToEndIdentifier;
    private Date dueDate;
    private Date expirationDate;
    private Boolean finality;
    private Double value;
    private Double changeValue;
    private Boolean canBePaidWithDifferentValue;
    private Boolean canModifyCashValue;
    private Double interest;
    private Double fine;
    private Double discount;
    private Double totalValue;
    private Double payer;
    private String description;
    private Boolean canBePaid;
    private String cannotBePaidReason;
    private QRCodeDecodeReceiver receiver;

}
