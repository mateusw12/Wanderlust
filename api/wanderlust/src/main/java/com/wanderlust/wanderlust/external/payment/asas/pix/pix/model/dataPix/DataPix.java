package com.wanderlust.wanderlust.external.payment.asas.pix.pix.model.dataPix;

import com.wanderlust.wanderlust.external.payment.asas.pix.pix.model.generatePix.GeneratePixQrCode;
import lombok.Data;

import java.util.Date;

@Data
public class DataPix {

    private String id;
    private String key;
    private String type;
    private String status;
    private Date dateCreated;
    private Boolean canBeDeleted;
    private Boolean cannotBeDeletedReason;
    private GeneratePixQrCode qrCode;

}
