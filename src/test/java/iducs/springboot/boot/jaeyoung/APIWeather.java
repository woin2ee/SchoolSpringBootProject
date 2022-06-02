package iducs.springboot.boot.jaeyoung;

public class APIWeather {
    private String area;
    private int precipitation;

    public APIWeather(String area, int precipitation) {
        this.area = area;
        this.precipitation = precipitation - 1;
    }

    public String getArea() {
        return area;
    }

    public int getPrecipitation() {
        return precipitation;
    }
}
