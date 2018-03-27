package com.hxm.rxjava2retrofit2mvp.net;


import com.hxm.rxjava2retrofit2mvp.net.manager.HttpManager;

import io.reactivex.ObservableTransformer;

/**
 * Created by hxm on 2018/3/11.
 * 描述：
 */
public class Request {
    private ObservableTransformer transformer = HttpManager.getInstance().threadTransformer();
    private ApiService service = HttpManager.getInstance().getRetrofit().create(ApiService.class);

    public static Request getInstance() {
        return RequestHolder.request;
    }

    private static class RequestHolder {
        private static final Request request = new Request();
    }
}
