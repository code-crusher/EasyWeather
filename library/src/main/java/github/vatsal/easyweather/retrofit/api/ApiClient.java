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

    private static ApiClient uniqInstance;
    private final String URL_LIVE = "http://api.openweathermap.org/data/2.5/";

    private WeatherInterface weatherInterface;

    public static synchronized ApiClient getInstance() {
        if (uniqInstance == null) {
            uniqInstance = new ApiClient();
        }
        return uniqInstance;
    }

    private void ApiClient(final String appId) {
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

                    builder.addHeader(WeatherInterface.FIELDS.APPID, appId);
                    Request request = builder.build();

                    return chain.proceed(request);
                }
            };

   /*         Interceptor bodyInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {

                    Request request = chain.request();
                    Response response = chain.proceed(request);

                   // String stringJson = response.body().toString();
                    //response.body().bytes();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(response.body().toString());
                        jsonObject.put("_3h", jsonObject.get("3h"));
                        jsonObject.remove("3h");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    MediaType contentType = response.body().contentType();
                    ResponseBody body = ResponseBody.create(contentType, String.valueOf(jsonObject));
                    return response.newBuilder().body(body).build();

                }
            };*/

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(headerInterceptor)
                    .addInterceptor(logging)
                    //      .addInterceptor(bodyInterceptor)
                    .build();
            //httpClient.networkInterceptors().add(headerInterceptor);

            String API_URL = URL_LIVE;

            // <-- this is the important line!
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();

            weatherInterface = retrofit.create(WeatherInterface.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WeatherInterface getApi(String appId) {
        if (uniqInstance == null) {
            getInstance();
        }
        uniqInstance.ApiClient(appId);

        return weatherInterface;
    }
}
