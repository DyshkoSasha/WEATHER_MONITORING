package my.company.weather_monitoring.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum City {

    MINSK("/53.8994;27.5582/202111141200?api_token=XSVRg6P1q0rm1hDE"),
    BREST("/49.8479;35.6541/202111141200?api_token=XSVRg6P1q0rm1hDE"),
    BERYOZA("/52.5348;24.9842/202111141200?api_token=XSVRg6P1q0rm1hDE"),
    BARANOVICHI("/53.8994;27.5582/202111141200?api_token=XSVRg6P1q0rm1hDE"),
    MOSCOW("/55.7555;37.6195/202111141200?api_token=XSVRg6P1q0rm1hDE");

    private final String uri;

    public String getUri() {
        return uri;
    }
}
