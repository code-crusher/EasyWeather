package github.vatsal.easyweather.retrofit.models;

import java.util.Arrays;

/**
 * Created by
 * --Vatsal Bajpai under
 * --AppyWare on
 * --23/06/16 at
 * --1:50 AM in
 * --OpenWeatherMapDemo
 */
public class DailyForecast {

    private String dt;

    private Temp temp;

    private String pressure;

    private String humidity;

    private Weather[] weather;

    private String speed;

    private String deg;

    private String clouds;

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    @Override
    public String toString() {
        return "DailyForecast{" +
                "dt='" + dt + '\'' +
                ", temp=" + temp +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                ", weather=" + Arrays.toString(weather) +
                ", speed='" + speed + '\'' +
                ", deg='" + deg + '\'' +
                ", clouds='" + clouds + '\'' +
                '}';
    }
}
