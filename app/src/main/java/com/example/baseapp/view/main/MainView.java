package com.example.baseapp.view.main;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;

import com.example.baseapp.R;
import com.example.baseapp.view.base.BaseView;

public class MainView extends BaseView {

    private static final int TIME_DELAY = 2000;
    private FrameLayout mFrameSplashScreen;
    private FrameLayout mFrameInit;
    private FrameLayout mHomeContainer;
    private FrameLayout mContainer;
    private FrameLayout mCtlMainContainer;


    public MainView(Context context) {
        super(context);
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initElementLayouts() {
        mFrameSplashScreen = findViewById(R.id.frame_splash);
        mFrameInit = findViewById(R.id.frame_init);
        mHomeContainer = findViewById(R.id.home_container);
        mContainer = findViewById(R.id.container);
        mCtlMainContainer = findViewById(R.id.ctl_main_container);
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

    public void hideSplashScreen() {
        mFrameSplashScreen.postDelayed(() -> {
            mFrameSplashScreen.setAnimation(getFadeOutAnimate());
            mFrameSplashScreen.setVisibility(View.GONE);
        }, TIME_DELAY);
    }

    public void showSplashScreen() {

    }

    private Animation getFadeOutAnimate() {
        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(TIME_DELAY);
        fadeOut.setDuration(TIME_DELAY);
        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeOut);
        return animation;
    }

    private Animation getFadeInAnimate() {
        Animation fadeOut = new AlphaAnimation(0, 1);
        fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
        fadeOut.setStartOffset(TIME_DELAY);
        fadeOut.setDuration(TIME_DELAY);
        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeOut);
        return animation;
    }
}
