package my.company.weather_monitoring.exception;

public class NullCityException extends RuntimeException {
    public NullCityException(String mesagge) {
        super(mesagge);
    }
}
