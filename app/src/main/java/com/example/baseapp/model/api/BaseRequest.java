package com.example.baseapp.model.api;

import com.example.baseapp.common.Common;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseRequest {

    public static Retrofit primaryRetrofit;

    public static OnApiRequest callApiRequest() {

        primaryRetrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.MAIN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getLoginOkHttpClient())
                .build();
        return primaryRetrofit.create(OnApiRequest.class);
    }

    public static OnApiRequest callApiRequestCreateOrder(String data) {

        primaryRetrofit = new Retrofit.Builder()
            .baseUrl(ApiUrl.MAIN_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getCreateOrderOkHttpClient(data))
            .build();
        return primaryRetrofit.create(OnApiRequest.class);
    }

    private static OkHttpClient getLoginOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(Common.CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(Common.READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.addInterceptor(getHeader());

        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(log);

        return httpClient.build();
    }

    private static OkHttpClient getCreateOrderOkHttpClient(String data) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(Common.CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.readTimeout(Common.READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        httpClient.addInterceptor(getCreateOrderHeader(data));

        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(log);

        return httpClient.build();
    }
    private static Interceptor getCreateOrderHeader(String data) {

        return chain -> {
            Request original = chain.request();
            MultipartBody.Builder builder = new MultipartBody.Builder();
            builder.setType(MultipartBody.FORM);
            builder.addFormDataPart("data", data);
            Request request = original.newBuilder()
                .method(original.method(), original.body())
                .post(builder.build())
                .build();
            return chain.proceed(request);
        };
    }

    private static Interceptor getHeader() {

        return chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                .method(original.method(), original.body())

                .build();
            return chain.proceed(request);
        };
    }
}
