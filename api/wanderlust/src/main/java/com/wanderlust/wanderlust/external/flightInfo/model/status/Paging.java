package com.wanderlust.wanderlust.external.flightInfo.model.status;

import lombok.Data;

@Data
public class Paging {

    private int totalCount;
    private int totalPages;
    private String next;

}
