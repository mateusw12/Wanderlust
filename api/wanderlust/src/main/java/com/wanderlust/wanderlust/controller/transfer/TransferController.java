package com.wanderlust.wanderlust.controller.transfer;

import com.wanderlust.wanderlust.external.tranfer.taxiFare.TaxiFareService;
import com.wanderlust.wanderlust.external.tranfer.taxiFare.model.TaxiFare;
import com.wanderlust.wanderlust.external.tranfer.taxiFare.model.filter.TaxiFareFilter;
import com.wanderlust.wanderlust.external.tranfer.waze.WazeService;
import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.WazeAlertAndJams;
import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.WazeAlertAndJamsFilter;
import com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection.WazeDrivingDirection;
import com.wanderlust.wanderlust.external.tranfer.waze.model.drivingDirection.WazeDrivingDirectionFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("api/transfer")
@Tag(name = "Consulta de tranfers")
public class TransferController {

    @Autowired
    private WazeService wazeService;

    @Autowired
    private TaxiFareService taxiFareService;

    @PostMapping("/waze/alert-jams")
    @Operation(summary = "Consulta transfer pelo waze")
    public WazeAlertAndJams findAlertAndJams(@RequestBody @NotNull WazeAlertAndJamsFilter filter) {
        return wazeService.findAlertAndJams(filter);
    }

    @PostMapping("/waze/driving-direction")
    @Operation(summary = "Consulta condução pelo waze")
    public WazeDrivingDirection findDrivingDirections(@RequestBody @NotNull WazeDrivingDirectionFilter filter) {
        return wazeService.findDrivingDirections(filter);
    }

    @PostMapping("/taxi-fare")
    @Operation(summary = "Consulta tarifa de taxi")
    public TaxiFare findTaxiFare(@RequestBody @NotNull TaxiFareFilter filter) {
        return taxiFareService.findTaxiFare(filter);
    }

}
