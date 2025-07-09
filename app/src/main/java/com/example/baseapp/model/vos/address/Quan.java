package com.example.baseapp.model.vos.address;

public class Quan {
    String quan_id;
    String quan_name;

    public Quan(String quan_id, String quan_name) {
        this.quan_id = quan_id;
        this.quan_name = quan_name;
    }

    public String getQuan_id() {
        return quan_id;
    }

    public void setQuan_id(String quan_id) {
        this.quan_id = quan_id;
    }

    public String getQuan_name() {
        return quan_name;
    }

    public void setQuan_name(String quan_name) {
        this.quan_name = quan_name;
    }
}
