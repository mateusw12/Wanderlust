package com.wanderlust.wanderlust.external.payment.asas.bankTransfer.customer.model;

import lombok.Data;

import java.util.List;

@Data
public class CustomersResponse {

    private String object;
    private Boolean hasMore;
    private Long totalCount;
    private Long limit;
    private Long offset;
    private List<CustomerResponse> data;

}
