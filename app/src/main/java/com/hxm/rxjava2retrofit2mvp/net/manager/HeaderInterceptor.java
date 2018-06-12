package com.hxm.rxjava2retrofit2mvp.net.manager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder()
                .addHeader("token", "ddddd")
                .addHeader("deciceId", "adkgkgk")
                .addHeader("OS", "android")
                .addHeader("type", "user")
                .build();
        return chain.proceed(request);
    }
}
