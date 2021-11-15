package my.company.weather_monitoring.service;

import lombok.RequiredArgsConstructor;
import my.company.weather_monitoring.exception.NullCityException;
import my.company.weather_monitoring.model.City;
import my.company.weather_monitoring.model.DataWeather;
import my.company.weather_monitoring.repository.DataWeatherRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class DataWeatherServiceImpl implements DataWeatherService {

    private final DataWeatherRepository dataWeatherRepository;
    private final WebClient webClient;

    @Override
    @Scheduled(fixedRate = 300000)
    public void saveDataWeather() {
        dataWeatherAdd(City.MINSK);
        dataWeatherAdd(City.BARANOVICHI);
        dataWeatherAdd(City.BERYOZA);
        dataWeatherAdd(City.BREST);
        dataWeatherAdd(City.MOSCOW);
    }

    @Override
    public DataWeather dataWeatherAdd(City city) {

        DataWeather weather = webClient
                .get()
                .uri(city.getUri())
                .retrieve()
                .bodyToMono(DataWeather.class)
                .block();
        weather.setCity(city.name());
        weather.setDate(LocalDateTime.now());
        dataWeatherRepository.save(weather);
        return weather;
    }

    @Override
    public DataWeather findDataWeatherByCityAndDate(City city, LocalDateTime date) {

        if (date == null) {
            return dataWeatherRepository.findFirstByCityOrderByDateDesc(
                    city.name()).orElse(dataWeatherAdd(city));
        }
        return dataWeatherRepository.findFirstByCityAndDateBeforeOrderByDateDesc(
                city.name(), date).orElseThrow(() -> new NullCityException("Данные за указанный город отсутствует"));
    }
}
