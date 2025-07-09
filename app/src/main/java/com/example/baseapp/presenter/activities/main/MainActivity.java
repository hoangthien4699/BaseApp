package com.example.baseapp.presenter.activities.main;

import android.view.View;

import com.example.baseapp.R;
import com.example.baseapp.presenter.activities.base.BaseActivity;
import com.example.baseapp.presenter.fragments.login.LoginFragment;
import com.example.baseapp.view.main.MainView;


public class MainActivity extends BaseActivity {

    private MainView mView;
    @Override
    public View getActivityView() {
        mView = new MainView(this);
        return mView;
    }

    @Override
    public void setValue() {
        mView.hideSplashScreen();
        openLoginScreen();
    }

    @Override
    public void setEvent() {

    }

    private void openLoginScreen() {
        LoginFragment fragment = LoginFragment.newInstance();
        openFragment(R.id.frame_init, fragment);
    }
}