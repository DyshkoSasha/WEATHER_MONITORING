package my.company.weather_monitoring.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import my.company.weather_monitoring.model.DataWeather;
import my.company.weather_monitoring.service.DataWeatherService;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@Log
public class DataWeatherController  {
    private final DataWeatherService dataWeatherService;

    @GetMapping("/add")
    public void saveDataWeather() {
       dataWeatherService.getWeatherAdd();
    }
}
