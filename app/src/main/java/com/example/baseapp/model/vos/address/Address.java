package com.example.baseapp.model.vos.address;

public class Address {
    private String ho_va_ten;
    private double lat;
    private double lng;
    private String adress;
    private String delivery_address;
    private String email;
    private String phone_number;
    private String image;
    private String description;
    private String created_at;
    private String updated_at;
    private String updated_by_user_id;
    private String tinh_id;
    private String tinh_name;
    private String quan_id;
    private String quan_name;
    private String phuong_id;
    private String phuong_name;

    public String getHo_va_ten() {
        return ho_va_ten;
    }

    public void setHo_va_ten(String ho_va_ten) {
        this.ho_va_ten = ho_va_ten;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        if (phone_number == null) return "";
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by_user_id() {
        return updated_by_user_id;
    }

    public void setUpdated_by_user_id(String updated_by_user_id) {
        this.updated_by_user_id = updated_by_user_id;
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
