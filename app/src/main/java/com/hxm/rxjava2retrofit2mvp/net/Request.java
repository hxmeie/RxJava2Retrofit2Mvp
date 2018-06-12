package com.hxm.rxjava2retrofit2mvp.net;


import com.hxm.rxjava2retrofit2mvp.entity.Result;
import com.hxm.rxjava2retrofit2mvp.net.manager.HttpManager;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

/**
 * Created by hxm on 2018/3/11.
 * 描述：
 */
@SuppressWarnings("unchecked")
public class Request {
    private ObservableTransformer transformer = HttpManager.getInstance().threadTransformer();
    private ApiService service = HttpManager.getInstance().getRetrofit().create(ApiService.class);

    public static Request getInstance() {
        return RequestHolder.request;
    }

    private static class RequestHolder {
        private static final Request request = new Request();
    }

    public Observable<Result> getResult() {
        Map<String, String> params = new HashMap<>();
        params.put("pageNum", "1");
        params.put("pageSize", "1");
        return service.getResult(params).compose(transformer);
    }
}
