package com.example.baseapp.model.api;

import com.example.baseapp.model.vos.accountuser.AccountUser;
import com.example.baseapp.model.vos.address.Address;
import com.example.baseapp.model.vos.address.Phuong;
import com.example.baseapp.model.vos.address.Quan;
import com.example.baseapp.model.vos.address.Tinh;
import com.example.baseapp.model.vos.base.BaseModel;
import com.example.baseapp.model.vos.base.BaseRes;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OnApiRequest {
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
    })

    @POST("index.php?r=api/taodonhangcrm")
    Call<BaseModel> createOrder();

    @POST("index.php?r=api%2Flogin")
    Call<BaseRes<AccountUser>> login(@Query("login") String user, @Query("password") String password, @Query("rememberMe") int rememberMe);

    @POST("index.php?r=api/ds_chi_giao_hang")
    Call<BaseRes<Address>> getListAddress(@Query("user_id") String user_id);

    @POST("index.php?r=api/dstinh")
    Call<BaseRes<Tinh>> getListTinh();

    @POST("index.php?r=api/dsquan")
    Call<BaseRes<Quan>> getListQuan(@Query("tinh_id") String tinhId);

    @POST("index.php?r=api/dsphuong")
    Call<BaseRes<Phuong>> getListPhuong(@Query("quan_id") String quanId);
}
