package github.vatsal.easyweather.Helper;

import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;

/**
 * Created by MotoBeans on 6/23/2016.
 */
public abstract class WeatherCallback {

    public abstract void success(WeatherResponseModel response);

    public abstract void failure(String message);
}
