package com.hxm.rxjava2retrofit2mvp.net.converter;

import com.google.gson.TypeAdapter;
import com.hxm.rxjava2retrofit2mvp.util.LogUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by hexiaomeng on 2017/4/13.
 * 解密数据
 */
public class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<T> adapter;

    ResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        //value.string()方法只能调用一次，不然会崩溃 Caused by: java.lang.IllegalStateException: closed
        String result = value.string();
        LogUtil.showLargeLog("OkHttp_Result", result, 3000);
        return adapter.fromJson(result);
    }
}
