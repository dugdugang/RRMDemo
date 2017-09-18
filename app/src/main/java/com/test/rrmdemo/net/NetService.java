package com.test.rrmdemo.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/9/18 0018.
 */

public class NetService {
    private static NetApi netApi;
    private static OkHttpClient okHttpClient = new OkHttpClient();

    public static NetApi getNetApi() {
        if (netApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://api.douban.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            netApi = retrofit.create(NetApi.class);
        }
        return netApi;
    }
}
