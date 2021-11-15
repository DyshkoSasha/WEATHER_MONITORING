package my.company.weather_monitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class DataWeather {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
    private Long id;

//    @Column(name = "city")
    private String city;

//    @Column(name = "temp")
    @JsonProperty("t")
    private String temp;

//    @Column(name = "pressure")
    @JsonProperty("sp")
    private String pressure;

//    @Column(name = "wind")
    @JsonProperty("speed10")
    private String wind;

//    @Column(name = "rain")
    @JsonProperty("crain")
    private String rain;

//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime date;

}
