package demo.components.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.elasticsearch.action.fieldstats.FieldStats;

import java.util.Date;

/**
 * Created by zemoso on 6/9/17.
 */
public class Weather {
    @JsonProperty(value = "location")
    private GeoPoint location;

    @JsonProperty(value="id")
    private String id;

    @JsonProperty(value = "date_time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date date_time;

    @JsonProperty(value = "condition")
    private String condition;

    @JsonProperty(value = "temperature_min_f")
    private double temperature_min_f;

    @JsonProperty(value = "temperature_max_f")
    private double temperature_max_f;

    @JsonProperty(value = "pressure_hpa")
    private double pressure_hpa;

    @JsonProperty(value = "humidity")
    private double humidity;

    @JsonProperty(value = "wind_speed_kn")
    private double wind_speed_kn;

    @JsonProperty(value = "wind_direction_deg")
    private double wind_direction_deg;

    @JsonProperty(value = "cloudiness")
    private double cloudiness;

    @JsonProperty(value = "precipitation_intensity_ft")
    private double precipitation_intensity_ft;

    @JsonProperty(value = "precipitation_probability")
    private double precipitation_probability;

    @JsonProperty(value = "")
    private double dew_point;

    @JsonProperty(value = "provider")
    private String provider;

    @JsonProperty(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date update_time;

    public GeoPoint getLocation() {
        return location;
    }

    public void setLocation(GeoPoint location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getTemperature_min_f() {
        return temperature_min_f;
    }

    public void setTemperature_min_f(double temperature_min_f) {
        this.temperature_min_f = temperature_min_f;
    }

    public double getTemperature_max_f() {
        return temperature_max_f;
    }

    public void setTemperature_max_f(double temperature_max_f) {
        this.temperature_max_f = temperature_max_f;
    }

    public double getPressure_hpa() {
        return pressure_hpa;
    }

    public void setPressure_hpa(double pressure_hpa) {
        this.pressure_hpa = pressure_hpa;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWind_speed_kn() {
        return wind_speed_kn;
    }

    public void setWind_speed_kn(double wind_speed_kn) {
        this.wind_speed_kn = wind_speed_kn;
    }

    public double getWind_direction_deg() {
        return wind_direction_deg;
    }

    public void setWind_direction_deg(double wind_direction_deg) {
        this.wind_direction_deg = wind_direction_deg;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    public double getPrecipitation_intensity_ft() {
        return precipitation_intensity_ft;
    }

    public void setPrecipitation_intensity_ft(double precipitation_intensity_ft) {
        this.precipitation_intensity_ft = precipitation_intensity_ft;
    }

    public double getPrecipitation_probability() {
        return precipitation_probability;
    }

    public void setPrecipitation_probability(double precipitation_probability) {
        this.precipitation_probability = precipitation_probability;
    }

    public double getDew_point() {
        return dew_point;
    }

    public void setDew_point(double dew_point) {
        this.dew_point = dew_point;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "location=" + location +
                ", id='" + id + '\'' +
                ", date_time=" + date_time +
                ", condition='" + condition + '\'' +
                ", temperature_min_f=" + temperature_min_f +
                ", temperature_max_f=" + temperature_max_f +
                ", pressure_hpa=" + pressure_hpa +
                ", humidity=" + humidity +
                ", wind_speed_kn=" + wind_speed_kn +
                ", wind_direction_deg=" + wind_direction_deg +
                ", cloudiness=" + cloudiness +
                ", precipitation_intensity_ft=" + precipitation_intensity_ft +
                ", precipitation_probability=" + precipitation_probability +
                ", dew_point=" + dew_point +
                ", provider='" + provider + '\'' +
                ", update_time=" + update_time +
                '}';
    }
}
