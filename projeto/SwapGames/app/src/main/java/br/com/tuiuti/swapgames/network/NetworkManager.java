package br.com.tuiuti.swapgames.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private static final String URL = "http://192.168.25.179/swapgames/";

    private static NetworkManager sInstance = new NetworkManager();

    private final Retrofit mRetrofit;
    private final RestService mRestService;

    private NetworkManager(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRestService = mRetrofit.create(RestService.class);
    }

    private static NetworkManager getInstance() {
        if (sInstance == null) sInstance = new NetworkManager();
        return sInstance;
    }

    public static RestService service() {
        return getInstance().mRestService;
    }
}
