package com.example.baseapp.model.api;

import com.google.gson.Gson;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class AppCallBack <T extends ResponseBody> implements Callback<T> {
    public abstract void onSuccess(T response);

    public abstract void onFailed(ApiError apiError);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful() && response.body() != null) {
            onSuccess(response.body());
        } else {
            if (response.code() >= 400 && response.code() < 500) {
                try {
                    Reader reader = new InputStreamReader(response.errorBody().byteStream(), StandardCharsets.UTF_8);
                    Gson gson = new Gson();
                    ApiError apiError = gson.fromJson(reader, ApiError.class);
                    onFailed(apiError);
                } catch (Exception e) {
                }
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        try {
            ApiError error = new ApiError(0, t.getMessage());
            onFailed(error);
        } catch (IllegalStateException ignore) {

        }
    }

}
