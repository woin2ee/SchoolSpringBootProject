package iducs.springboot.boot.jaeyoung;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WeatherService {
    private final WeatherRequester weatherRequester;

    public WeatherService(WeatherRequester weatherRequester) {
        this.weatherRequester = weatherRequester;
    }

    public WeatherResponse getWeather(String area) {
        APIWeather apiWeather = weatherRequester.getWeather(area);
        return new WeatherResponse(apiWeather.getArea(), apiWeather.getPrecipitation());
    }
}
