package com.wanderlust.wanderlust.external.payment.asas.pix.pix.model.generatePix;

import lombok.Data;

import java.util.Date;

@Data
public class GeneratePix {

    private String id;
    private String key;
    private String type;
    private String status;
    private Date dateCreated;
    private Boolean canBeDeleted;
    private String cannotBeDeletedReason;
    private GeneratePixQrCode qrCode;

}
