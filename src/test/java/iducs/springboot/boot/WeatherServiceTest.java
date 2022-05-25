package iducs.springboot.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeatherServiceTest {

    StubWeatherRequester weatherRequester;
    WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherRequester = new StubWeatherRequester();
        weatherService = new WeatherService(weatherRequester);
    }

    @Test
    void 외부_API로_부터_데이터를_받은_후_WeatherResponse로_변환한다() {
        // given
        weatherRequester.save(new APIWeather("의정부", 3));

        // when
        WeatherResponse response = weatherService.getWeather("의정부");

        // then
        assertEquals(2, response.getPrecipitation());
    }

    @Test
    void 대프리카_테스트() {
        // when
        assertThrows(IllegalArgumentException.class, () -> weatherService.getWeather("대프리카"));
    }
}
