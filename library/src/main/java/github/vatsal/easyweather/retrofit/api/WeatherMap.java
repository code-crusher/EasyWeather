package github.vatsal.easyweather;

import android.content.Context;
import android.support.annotation.Nullable;

import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.retrofit.api.ApiClient;
import github.vatsal.easyweather.retrofit.api.WeatherInterface;
import github.vatsal.easyweather.retrofit.api.WeatherRetrofitCallback;
import github.vatsal.easyweather.retrofit.models.CurrentWeatherResponseModel;
import github.vatsal.easyweather.retrofit.models.DailyForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
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
    String lang;

    ApiClient apiClient;
    WeatherInterface weatherInterface;

    public WeatherMap(Context context, String APP_ID, String lang) {
        this.context = context;
        this.APP_ID = APP_ID;
        this.lang = lang;
        apiClient = ApiClient.getInstance();
        this.weatherInterface = apiClient.
    }


    public void getCityWeather(String city, WeatherCallback<CurrentWeatherResponseModel> weatherCallback) {
        try {
            Call objCall = apiClient.getApi(context).getCityWeather(APP_ID, city, lang);

            if (objCall != null) {
                enqueue(weatherCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocationWeather(String latitude, String longitude, WeatherCallback<CurrentWeatherResponseModel> weatherCallback) {
        try {
            Call objCall = apiClient.getApi(context).getLocationWeather(APP_ID, latitude, longitude, lang);

            if (objCall != null) {
                enqueue(weatherCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getCityForecast(String city, WeatherCallback<ForecastResponseModel> forecastCallback) {

        try {
            Call objCall = apiClient.getApi(context).getCityForcast(APP_ID, city, lang);

            if (objCall != null) {
                enqueue(forecastCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocationForecast(String latitude, String longitude, WeatherCallback<ForecastResponseModel> forecastCallback) {
        try {
            Call objCall = apiClient.getApi(context).getLocationForecast(APP_ID, latitude, longitude, lang);

            if (objCall != null) {
                enqueue(forecastCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getCityDailyForecast(String city, @Nullable String dayCount, WeatherCallback<DailyForecastResponseModel> forecastCallback) {
        try {
            Call objCall = (dayCount == null)?apiClient.getApi(context).getCityDailyForcast(APP_ID, city, lang):apiClient.getApi(context).getCityDailyForcast(APP_ID, city, dayCount, lang);

            if (objCall != null) {
                enqueue(forecastCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getCityDailyForecast(String city, WeatherCallback<DailyForecastResponseModel> forecastCallback) {
        getCityDailyForecast(city, null, forecastCallback);
    }

    public void getLocationDailyForecast(String latitude, String longitude, @Nullable String dayCount, WeatherCallback<DailyForecastResponseModel> forecastCallback) {
        try {
            Call objCall = (dayCount == null)?apiClient.getApi(context).getLocationDailyForecast(APP_ID, latitude, longitude, lang):apiClient.getApi(context).getLocationDailyForecast(APP_ID, latitude, longitude, dayCount, lang);

            if (objCall != null) {
                enqueue(forecastCallback, objCall);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getLocationDailyForecast(String latitude, String longitude, WeatherCallback<DailyForecastResponseModel> forecastCallback) {
        getLocationDailyForecast(latitude, longitude, null, forecastCallback);
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
