package github.vatsal.easyweather.Helper;

/**
 * Created by
 --Vatsal Bajpai on
 --6/23/2016 at
 --4:29 PM
 */
public abstract class WeatherCallback<T> {

    public abstract void success(T response);

    public abstract void failure(String message);
}
