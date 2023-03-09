package com.wanderlust.wanderlust.external.payment.asas.model.pix.dataPix;

import lombok.Data;

@Data
public class Pix {

    private Long totalCount;
    private Long limit;
    private Long offset;
    private Boolean hasMore;
    private DataPix data;

}
