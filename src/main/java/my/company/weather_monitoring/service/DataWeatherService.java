package my.company.weather_monitoring.service;


import my.company.weather_monitoring.model.City;
import my.company.weather_monitoring.model.DataWeather;

import java.time.LocalDateTime;

public interface DataWeatherService {

    void saveDataWeather();

    void dataWeatherAdd(City city);

    DataWeather findDataWeatherByCityAndDate(String city, LocalDateTime date);

}
