package my.company.weather_monitoring.service;


import my.company.weather_monitoring.model.DataWeather;
import reactor.core.publisher.Mono;

public interface DataWeatherService {
    void getWeatherAdd();
}
