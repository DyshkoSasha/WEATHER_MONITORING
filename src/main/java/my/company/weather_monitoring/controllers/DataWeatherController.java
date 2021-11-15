package my.company.weather_monitoring.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import my.company.weather_monitoring.model.DataWeather;
import my.company.weather_monitoring.service.DataWeatherService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Log
public class DataWeatherController  {
    private final DataWeatherService dataWeatherService;

    @GetMapping("/get/{city}")
    public DataWeather getDataWeather(@PathVariable String city,
                                      @RequestParam(required = false)
                                      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                      LocalDateTime date) {
      return dataWeatherService.findDataWeatherByCityAndDate(city, date);
    }
}
