package com.wanderlust.wanderlust.external.tranfer.taxiFare.model;

import lombok.Data;

@Data
public class Fares {

    private String name;
    private Long price_in_cents;
    private Boolean estimated;

}
