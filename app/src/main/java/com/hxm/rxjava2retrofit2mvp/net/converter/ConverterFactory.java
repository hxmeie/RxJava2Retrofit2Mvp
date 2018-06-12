package com.hxm.rxjava2retrofit2mvp.net.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by hexiaomeng on 2017/4/13.
 * 解密数据
 */
public final class ConverterFactory extends Converter.Factory {
    private final Gson gson;

    private ConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    public static ConverterFactory create() {
        return create(new Gson());
    }

    public static ConverterFactory create(Gson gson) {
        return new ConverterFactory(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new ResponseBodyConverter<>(adapter);
    }
}
