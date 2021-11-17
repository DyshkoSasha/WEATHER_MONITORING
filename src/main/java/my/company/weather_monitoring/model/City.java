package my.company.weather_monitoring.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum City {

    MINSK("/53.8994;27.5582"),
    BREST("/49.8479;35.6541"),
    BERYOZA("/52.5348;24.9842"),
    BARANOVICHI("/53.8994;27.5582"),
    MOSCOW("/55.7555;37.6195");

    private final String uri;

}
