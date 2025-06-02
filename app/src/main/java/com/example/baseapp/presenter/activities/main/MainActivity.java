package com.example.baseapp.presenter.activities.main;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.qunlbnhngpate.R;
import com.example.qunlbnhngpate.presenter.activities.base.BaseActivity;
import com.example.qunlbnhngpate.presenter.fragments.login.LoginFragment;
import com.example.qunlbnhngpate.presenter.fragments.order.OrderFragment;
import com.example.qunlbnhngpate.view.main.MainView;

public class MainActivity extends BaseActivity {

    private View mView;
    @Override
    public View getActivityView() {
        mView = new MainView(this);
        return mView;
    }

    @Override
    public void setValue() {
        openFragment(R.id.frame_init, LoginFragment.newInstance());
    }
}