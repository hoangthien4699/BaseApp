package com.example.baseapp.model.vos.address;

public class Phuong {
    private String phuong_id;
    private String phuong_name;

    public Phuong(String phuong_id, String phuong_name) {
        this.phuong_id = phuong_id;
        this.phuong_name = phuong_name;
    }

    public String getPhuong_id() {
        return phuong_id;
    }

    public void setPhuong_id(String phuong_id) {
        this.phuong_id = phuong_id;
    }

    public String getPhuong_name() {
        return phuong_name;
    }

    public void setPhuong_name(String phuong_name) {
        this.phuong_name = phuong_name;
    }
}
