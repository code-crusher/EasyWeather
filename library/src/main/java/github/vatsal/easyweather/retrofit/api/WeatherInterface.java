package github.vatsal.easyweather.retrofit.api;

import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {

    @GET("weather")
    Call<WeatherResponseModel> getCityWeather(@Query(FIELDS.Q) String city);

    @GET("weather")
    Call<WeatherResponseModel> getLocationWeather(@Query(FIELDS.LAT) String latitude,
                                                  @Query(FIELDS.LON) String longitude);

    @GET("forecast")
    Call<ForecastResponseModel> getCityForcast(@Query(FIELDS.Q) String city);

    @GET("forecast")
    Call<ForecastResponseModel> getLocationForecast(@Query(FIELDS.LAT) String latitude,
                                                    @Query(FIELDS.LON) String longitude);

    interface FIELDS {
        String APPID = "appid";
        String Q = "q";
        String LAT = "lat";
        String LON = "lon";
    }
}
