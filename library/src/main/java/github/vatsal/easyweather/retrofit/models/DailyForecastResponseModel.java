package github.vatsal.easyweather.retrofit.models;

import java.util.Arrays;

/**
 * Created by
 * --Vatsal Bajpai under
 * --AppyWare on
 * --23/06/16 at
 * --1:48 AM in
 * --OpenWeatherMapDemo
 */
public class DailyForecastResponseModel {
    private String message;

    private String cnt;

    private String cod;

    private DailyForecast[] list;

    private City city;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCnt() {
        return cnt;
    }

    public void setCnt(String cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public DailyForecast[] getList() {
        return list;
    }

    public void setList(DailyForecast[] list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "DailyForecastResponseModel{" +
                "message='" + message + '\'' +
                ", cnt='" + cnt + '\'' +
                ", cod='" + cod + '\'' +
                ", list=" + Arrays.toString(list) +
                ", city=" + city +
                '}';
    }
}
