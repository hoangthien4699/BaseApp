package com.example.baseapp.model.vos.base;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

public class BaseRes<T> extends BaseModel {
    @Expose
    private ArrayList<T> data;

    public ArrayList<T> getData() {
        return data;
    }
}
