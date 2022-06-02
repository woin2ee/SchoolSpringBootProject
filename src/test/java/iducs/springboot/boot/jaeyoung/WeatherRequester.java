package iducs.springboot.boot.jaeyoung;

import java.util.List;

public interface WeatherRequester {
    APIWeather getWeather(String area);
    List<APIWeather> getWeathers();
}
