package com.example.baseapp.model.api;

import com.google.gson.annotations.SerializedName;

public class ApiError {
    private int code;
    @SerializedName("message")
    private String message;
    private int error;

    public ApiError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
