package github.vatsal.easyweather;

import android.content.Context;

import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.retrofit.api.ApiClient;
import github.vatsal.easyweather.retrofit.api.WeatherRetrofitCallback;
import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;
import retrofit2.Call;

/**
 * Created by
 * --Vatsal Bajpai under
 * --AppyWare on
 * --22/06/16 at
 * --2:44 AM in
 * --OpenWeatherMapDemo
 */
public class WeatherMap {

    Context context;
    String APP_ID;

    public WeatherMap(Context context, String APP_ID) {
        this.context = context;
        this.APP_ID = APP_ID;
    }

    public void getCityWeather(String city, WeatherCallback<WeatherResponseModel> weatherCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getCityWeather(APP_ID, city);

            if (objCall != null) {
                enqueue(weatherCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocationWeather(String latitude, String longitude, WeatherCallback<WeatherResponseModel> weatherCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getLocationWeather(APP_ID, latitude, longitude);

            if (objCall != null) {
                enqueue(weatherCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCityForecast(String city, WeatherCallback<ForecastResponseModel> forecastCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getCityForcast(APP_ID, city);

            if (objCall != null) {
                enqueue(forecastCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocationForecast(String latitude, String longitude, WeatherCallback<ForecastResponseModel> forecastCallback) {
        final ApiClient objApi = ApiClient.getInstance();
        try {
            Call objCall = null;

            objCall = objApi.getApi(context).getLocationForecast(APP_ID, latitude, longitude);

            if (objCall != null) {
                enqueue(forecastCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> void  enqueue(final WeatherCallback<T> callback, Call objCall){
        objCall.enqueue(new WeatherRetrofitCallback<T>(context) {

            @Override
            public void onFailure(Call call, Throwable t) {

                callback.failure("Failed");
                super.onFailure(call, t);
            }

            @Override
            protected void onResponseWeatherResponse(Call call, retrofit2.Response response) {

                if (!response.isSuccessful())
                    callback.failure("Failed");
            }

            @Override
            protected void onResponseWeatherObject(Call call, T response) {

                callback.success(response);
            }

            @Override
            protected void common() {

            }
        });
    }

}
