package my.company.weather_monitoring.repository;

import my.company.weather_monitoring.model.DataWeather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataWeatherRepository extends JpaRepository<DataWeather, Long> {

}
