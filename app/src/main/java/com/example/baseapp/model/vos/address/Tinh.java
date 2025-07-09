package com.example.baseapp.model.vos.address;

public class Tinh {
    private String tinh_id;
    private String tinh_name;

    public Tinh(String tinh_id, String tinh_name) {
        this.tinh_id = tinh_id;
        this.tinh_name = tinh_name;
    }

    public String getTinh_id() {
        return tinh_id;
    }

    public void setTinh_id(String tinh_id) {
        this.tinh_id = tinh_id;
    }

    public String getTinh_name() {
        return tinh_name;
    }

    public void setTinh_name(String tinh_name) {
        this.tinh_name = tinh_name;
    }
}
