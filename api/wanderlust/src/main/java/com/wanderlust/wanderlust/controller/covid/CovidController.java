package com.wanderlust.wanderlust.controller.covid;

import com.wanderlust.wanderlust.external.covid.CovidService;
import com.wanderlust.wanderlust.external.covid.model.statistics.CovidStatistics;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("api/covid")
@Tag(name = "Consulta de dados sobre COVID-19")
public class CovidController {

    @Autowired
    private CovidService covidService;

    @GetMapping("/country/{country}")
    @Operation(summary = "Consulta dados sobre covid por país")
    public CovidStatistics findAll(@PathVariable String country) {
        return covidService.findStatisticsCountry(country);
    }

}
