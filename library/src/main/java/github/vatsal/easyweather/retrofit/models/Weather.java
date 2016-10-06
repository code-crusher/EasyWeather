package github.vatsal.easyweather.retrofit.models;

/**
 * Created by
 * --Vatsal Bajpai under
 * --AppyWare on
 * --22/06/16 at
 * --8:23 PM in
 * --OpenWeatherMapDemo
 */
public class Weather {
    private static final String HTTP_OPENWEATHERMAP_ORG_IMG_W = "http://openweathermap.org/img/w/";

    private String id;

    private String icon;

    private String description;

    private String main;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public String getIconLink() {
        return String.format("%s%s.png", HTTP_OPENWEATHERMAP_ORG_IMG_W, icon);
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    @Override
    public String toString() {
        return String.format("ClassPojo [id = %s, icon = %s, description = %s, main = %s]", id, icon, description, main);
    }
}
