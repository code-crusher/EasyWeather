package github.vatsal.easyweather.retrofit.api;

import github.vatsal.easyweather.retrofit.models.DailyForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.CurrentWeatherResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {

    @GET("weather")
    Call<CurrentWeatherResponseModel> getCityWeather(@Query("appid") String appid,
                                                     @Query("q") String city);

    @GET("weather")
    Call<CurrentWeatherResponseModel> getLocationWeather(@Query("appid") String appid,
                                                         @Query("lat") String latitude,
                                                         @Query("lon") String longitude);

    @GET("forecast")
    Call<ForecastResponseModel> getCityForcast(@Query("appid") String appid,
                                               @Query("q") String city);

    @GET("forecast")
    Call<ForecastResponseModel> getLocationForecast(@Query("appid") String appid,
                                                    @Query("lat") String latitude,
                                                    @Query("lon") String longitude);

    @GET("forecast/daily")
    Call<DailyForecastResponseModel> getCityDailyForcast(@Query("appid") String appid,
                                               @Query("q") String city);
    @GET("forecast/daily")
    Call<DailyForecastResponseModel> getCityDailyForcast(@Query("appid") String appid,
                                                    @Query("q") String city,
                                                    @Query("cnt") String cnt);

    @GET("forecast/daily")
    Call<DailyForecastResponseModel> getLocationDailyForecast(@Query("appid") String appid,
                                                         @Query("lat") String latitude,
                                                         @Query("lon") String longitude);
    @GET("forecast/daily")
    Call<DailyForecastResponseModel> getLocationDailyForecast(@Query("appid") String appid,
                                                              @Query("lat") String latitude,
                                                              @Query("lon") String longitude,
                                                              @Query("cnt") String cnt);

}
