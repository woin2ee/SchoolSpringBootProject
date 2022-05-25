package iducs.springboot.boot;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Component
public class StubWeatherRequester implements WeatherRequester {
    private final Map<String, APIWeather> repo = new HashMap<>();

    public void save(APIWeather apiWeather) {
        repo.put(apiWeather.getArea(), apiWeather);
    }

    @Override
    public APIWeather getWeather(String area) {
        APIWeather apiWeather = repo.get(area);
        if(apiWeather == null) {
            throw new IllegalArgumentException();
        }
        return apiWeather;
    }

    @Override
    public List<APIWeather> getWeathers() {
        throw new UnsupportedOperationException();
    }
}
