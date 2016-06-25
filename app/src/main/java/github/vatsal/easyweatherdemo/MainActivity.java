package github.vatsal.easyweatherdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import github.vatsal.easyweather.Helper.ForecastCallback;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;

public class MainActivity extends AppCompatActivity {

    public final String APP_ID = BuildConfig.OWM_API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherMap weatherMap = new WeatherMap(this, APP_ID);
        weatherMap.getCityWeather("Delhi", new WeatherCallback() {
            @Override
            public void success(WeatherResponseModel response) {
                WeatherResponseModel responseModel = response;
            }

            @Override
            public void failure(String message) {

            }
        });

        weatherMap.getCityForecast("London", new ForecastCallback() {
            @Override
            public void success(ForecastResponseModel response) {
                ForecastResponseModel responseModel = response;
            }

            @Override
            public void failure(String message) {

            }
        });

    }
}
