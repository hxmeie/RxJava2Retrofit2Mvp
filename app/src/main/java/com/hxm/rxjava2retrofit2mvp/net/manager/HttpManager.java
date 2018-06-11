package com.hxm.rxjava2retrofit2mvp.net.manager;


import com.hxm.rxjava2retrofit2mvp.BuildConfig;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hxm on 2018/3/11.
 * 描述：
 */
public class HttpManager {
    private Retrofit retrofit;

    private HttpManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        //缓存
//        File httpCacheDirectory = new File(AppContext.getInstance().getCacheDir(), "http");
//        int cacheSize = 20 * 1024 * 1024; // 20 MiB
//        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
//                .addInterceptor(new CacheInterceptor())
                .retryOnConnectionFailure(true)
//                .cache(cache)
//                .sslSocketFactory()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.agx.com/")
                .client(client)
                .build();
    }

    public static HttpManager getInstance() {
        return HttpMangerHolder.instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public <T> ObservableTransformer<T, T> threadTransformer() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    private static class HttpMangerHolder {
        private static final HttpManager instance = new HttpManager();
    }
}
