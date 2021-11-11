package my.company.weather_monitoring.service;

import lombok.RequiredArgsConstructor;
import my.company.weather_monitoring.model.DataWeather;
import my.company.weather_monitoring.repository.DataWeatherRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@EnableScheduling
public class DataWeatherServiceImpl implements DataWeatherService {

    private final DataWeatherRepository dataWeatherRepository;
    private final WebClient webClient;


    @Override
    @Scheduled(fixedRate = 300000)
    public void getWeatherAdd() {
        dataWeatherRepository.save(Objects.requireNonNull(webClient
                .get()
                .retrieve()
                .bodyToMono(DataWeather.class)
                .block()));

    }


}
