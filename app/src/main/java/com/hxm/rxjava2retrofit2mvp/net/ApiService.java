package com.hxm.rxjava2retrofit2mvp.net;

import com.hxm.rxjava2retrofit2mvp.entity.Result;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by hxm on 2018/3/11.
 * 描述：
 */
public interface ApiService {

    @POST(NetApi.NOTICE)
    @FormUrlEncoded
    Observable<Result> getResult(@FieldMap Map<String, String> map);
}
