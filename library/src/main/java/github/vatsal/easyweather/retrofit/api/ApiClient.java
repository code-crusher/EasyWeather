package github.vatsal.easyweather.retrofit.api;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient instance;
    private static final String URL_LIVE = "http://api.openweathermap.org/data/2.5/";



    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    protected WeatherInterface getWeatherInterface() {
        WeatherInterface weatherInterface = null;
        try {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            Interceptor headerInterceptor = new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();
                    Request.Builder builder = original.newBuilder();
                    builder.method(original.method(), original.body());

                    Request request = builder.build();

                    return chain.proceed(request);
                }
            };

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(headerInterceptor)
                    .addInterceptor(logging)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL_LIVE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();

            weatherInterface = retrofit.create(WeatherInterface.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherInterface;
    }
}
