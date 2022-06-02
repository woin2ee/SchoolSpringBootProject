package iducs.springboot.boot.jaeyoung;

public class WeatherResponse {
    private final String area;
    private final int precipitation;

    public WeatherResponse(String area, int precipitation) {
        this.area = area;
        this.precipitation = (int) precipitation;
    }

    public int getPrecipitation() {
        return precipitation;
    }
}
