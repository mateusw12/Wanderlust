package com.wanderlust.wanderlust.controller.transfer;

import com.wanderlust.wanderlust.external.tranfer.waze.WazeService;
import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.WazeAlertAndJams;
import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.WazeAlertAndJamsFilter;
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

    @PostMapping("/waze/alert-jams")
    @Operation(summary = "Consulta transfer pelo waze")
    public WazeAlertAndJams findAlertAndJams(@RequestBody @NotNull WazeAlertAndJamsFilter filter) {
        return wazeService.findAlertAndJams(filter);
    }

}
