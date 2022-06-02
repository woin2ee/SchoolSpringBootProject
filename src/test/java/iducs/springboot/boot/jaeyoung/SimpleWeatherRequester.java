package iducs.springboot.boot.jaeyoung;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SimpleWeatherRequester implements WeatherRequester {

    @Override
    public APIWeather getWeather(String area) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("외부 API URL", APIWeather.class).getBody();
    }

    @Override
    public List<APIWeather> getWeathers() {
        RestTemplate restTemplate = new RestTemplate();
        return null;
    }
}
