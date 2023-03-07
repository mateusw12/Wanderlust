package com.wanderlust.wanderlust.external.tranfer.taxiFare.model;

import lombok.Data;

@Data
public class TaxiFare {

    private TaxiFareHeader headers;
    private TaxiFareJourney journey;

}
