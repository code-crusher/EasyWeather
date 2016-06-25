package github.vatsal.easyweather.Helper;

import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;

/**
 * Created by MotoBeans on 6/23/2016.
 */
public abstract class ForecastCallback {

    public abstract void success(ForecastResponseModel response);

    public abstract void failure(String message);
}
