package com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams;

import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.alert.WazeAlerts;
import com.wanderlust.wanderlust.external.tranfer.waze.model.alertAndJams.jams.WazeJams;
import lombok.Data;

import java.util.List;

@Data
public class WazeAlertAndJamsData {

    private List<WazeAlerts> alerts;
    private List<WazeJams> jams;

}
