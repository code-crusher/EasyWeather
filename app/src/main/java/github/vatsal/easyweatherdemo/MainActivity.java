package github.vatsal.easyweatherdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import github.vatsal.easyweather.Helper.TempUnitConverter;
import github.vatsal.easyweather.Helper.WeatherCallback;
import github.vatsal.easyweather.WeatherMap;
import github.vatsal.easyweather.retrofit.models.ForecastResponseModel;
import github.vatsal.easyweather.retrofit.models.Weather;
import github.vatsal.easyweather.retrofit.models.WeatherResponseModel;

public class MainActivity extends AppCompatActivity {

    public final String APP_ID = BuildConfig.OWM_API_KEY;
    String city = "San Francisco";

    @BindView(R.id.weather_title)
    TextView weatherTitle;
    @BindView(R.id.refresh)
    ImageButton refresh;
    @BindView(R.id.weather_icon)
    ImageView weatherIcon;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.condition)
    TextView condition;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.tvHumidity)
    TextView tvHumidity;
    @BindView(R.id.tvPressure)
    TextView tvPressure;
    @BindView(R.id.tvWind)
    TextView tvWind;
    @BindView(R.id.tvWindDeg)
    TextView tvWindDeg;
    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.tv_go)
    TextView tvGo;
    @BindView(R.id.textLayout)
    LinearLayout textLayout;
    @BindView(R.id.humidity_desc)
    TextView humidityDesc;
    @BindView(R.id.pres_desc)
    TextView presDesc;
    @BindView(R.id.ws_desc)
    TextView wsDesc;
    @BindView(R.id.wd_desc)
    TextView wdDesc;
    @BindView(R.id.ll_extraWeather)
    LinearLayout llExtraWeather;
    @BindView(R.id.weatherCard)
    CardView weatherCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loadWeather(city);
    }

    @OnClick(R.id.refresh)
    public void refresh() {
        loadWeather(city);
    }

    private void loadWeather(String city) {
        WeatherMap weatherMap = new WeatherMap(this, APP_ID);
        weatherMap.getCityWeather(city, new WeatherCallback<WeatherResponseModel>() {
            @Override
            public void success(WeatherResponseModel response) {
                populateWeather(response);
            }

            @Override
            public void failure(String message) {

            }
        });

        weatherMap.getCityForecast(city, new WeatherCallback<ForecastResponseModel>() {
            @Override
            public void success(ForecastResponseModel response) {
                ForecastResponseModel responseModel = response;
            }

            @Override
            public void failure(String message) {

            }
        });
    }

    private void populateWeather(WeatherResponseModel response) {

        Weather weather[] = response.getWeather();
        condition.setText(weather[0].getMain());
        temp.setText(TempUnitConverter.convertToCelsius(response.getMain().getTemp()).intValue() + " °C");
        location.setText(response.getName());

        tvHumidity.setText(response.getMain().getHumidity() + "%");
        tvPressure.setText(response.getMain().getPressure() + " hPa");
        tvWind.setText(response.getWind().getSpeed() + "m/s");
        tvWindDeg.setText(response.getWind().getDeg() + "°");

        String link = weather[0].getIconLink();
        Picasso.with(this).load(link).into(weatherIcon);
    }

    @OnClick(R.id.tv_go)
    public void go() {
        city = etCity.getText().toString().trim();
        loadWeather(city);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
