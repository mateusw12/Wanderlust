package com.wanderlust.wanderlust.controller.weatherForecast;

import com.wanderlust.wanderlust.dto.user.UserDTO;
import com.wanderlust.wanderlust.external.weatherForecast.WeatherForecastService;
import com.wanderlust.wanderlust.external.weatherForecast.model.WeatherForecast;
import com.wanderlust.wanderlust.external.weatherForecast.model.filter.WeatherForecastFilter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("api/consulta-previsao-tempo")
@Tag(name = "Consulta de previsão de tempo")
public class WeatherForecastController {

    @Autowired
    private WeatherForecastService weatherForecastService;

    @PostMapping("/forecast")
    @Operation(summary = "Consulta previsão de tempo")
    public WeatherForecast findMe(@RequestBody @Valid WeatherForecastFilter filter) {
        return weatherForecastService.forecast(filter);
    }

}
