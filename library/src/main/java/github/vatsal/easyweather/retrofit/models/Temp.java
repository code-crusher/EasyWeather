package github.vatsal.easyweather.retrofit.models;

/**
 * Created by sokarcreative on 08/04/2017.
 */

public class Temp {

    private String day;

    private String min;

    private String max;

    private String night;

    private String eve;

    private String morn;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getEve() {
        return eve;
    }

    public void setEve(String eve) {
        this.eve = eve;
    }

    public String getMorn() {
        return morn;
    }

    public void setMorn(String morn) {
        this.morn = morn;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "day='" + day + '\'' +
                ", min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", night='" + night + '\'' +
                ", eve='" + eve + '\'' +
                ", morn='" + morn + '\'' +
                '}';
    }
}
