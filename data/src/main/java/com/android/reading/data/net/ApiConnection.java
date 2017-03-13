package com.android.reading.data.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gu FanFan on 2017/3/2 20:40.
 * LoveReading.
 */

public class ApiConnection {

    private static ApiConnection sApiConnection;
    private volatile Retrofit mBaseRetrofit;

    public static ApiConnection newInstance() {
        if (sApiConnection == null)
            sApiConnection = new ApiConnection();
        return sApiConnection;
    }

    public Retrofit getBaseRetrofit() {
        if (mBaseRetrofit == null) {
            synchronized (Retrofit.class) {
                OkHttpClient okHttpClient = new OkHttpClient.Builder()
                        .connectTimeout(RequestApi.TIME_OUT, TimeUnit.SECONDS)
                        .writeTimeout(RequestApi.TIME_OUT, TimeUnit.SECONDS)
                        .build();

                mBaseRetrofit = new Retrofit.Builder()
                        .baseUrl(RequestApi.BASE_HOST)
                        .client(okHttpClient)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build();
            }
        }

        return mBaseRetrofit;
    }
}
