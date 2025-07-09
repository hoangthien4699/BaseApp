package com.example.baseapp.view.login;

import android.content.Context;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.baseapp.R;
import com.example.baseapp.view.base.BaseView;

public class LoginView extends BaseView {

    private AppCompatEditText mEdtUserName;
    private AppCompatEditText mEdtPassword;
    private AppCompatTextView mTvLogin;
    private AppCompatTextView mTvLoginFaceIDState;
    private AppCompatImageView mImgEye;
    private CheckBox mCbSaveLogin;
    private AppCompatTextView mTvPolicy;


    public LoginView(@NonNull Context context) {
        super(context);
        mEdtUserName = findViewById(R.id.edt_user_name);
        mEdtPassword = findViewById(R.id.edt_password);
        mTvLogin = findViewById(R.id.tv_login);
        mTvLoginFaceIDState = findViewById(R.id.tv_login_faceid_state);
        mImgEye = findViewById(R.id.img_eye);
        mCbSaveLogin = findViewById(R.id.cb_save_login);
    }

    @Override
    public int getViewLayout() {
        return R.layout.fragment_login;
    }

    @Override
    public void initElementLayouts() {

    }

    @Override
    public void setValue() {

    }

    @Override
    public void setEvent() {

    }

    @Override
    public void configHeaderBar() {

    }
}
