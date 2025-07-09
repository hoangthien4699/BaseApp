package com.example.baseapp.presenter.activities.main;

import android.view.View;

import androidx.core.splashscreen.SplashScreen;

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
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
//        setupSplashScreen(splashScreen);
        splashScreen.setKeepOnScreenCondition(() -> {
            return true; // Kiểm tra xem app đã sẵn sàng chưa
        });
        openLoginScreen();
    }

    @Override
    public void setEvent() {

    }

    private void openLoginScreen() {
        LoginFragment fragment = LoginFragment.newInstance();
        openFragment(R.id.frame_init, fragment);
    }

    private void setupSplashScreen(SplashScreen splashScreen) {
        // Giữ splash screen hiển thị lâu hơn
        splashScreen.setKeepOnScreenCondition(() -> {
            return true; // Kiểm tra xem app đã sẵn sàng chưa
        });

        // Tùy chỉnh animation thoát
//        splashScreen.setOnExitAnimationListener(splashScreenView -> {
//            ObjectAnimator slideUp = ObjectAnimator.ofFloat(
//                    splashScreenView,
//                    String.valueOf(View.TRANSLATION_Y),
//                    0f,
//                    - (float) splashScreenView.getView().getHeight()
//            );
//            slideUp.setDuration(2000L);
//            slideUp.setInterpolator(new AnticipateInterpolator());
//            slideUp.addListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    splashScreenView.remove();
//                }
//            });
//            slideUp.start();
//        });
    }

    private boolean isAppReady() {
        // Logic kiểm tra app đã sẵn sàng (data loaded, etc.)
        return true;
    }
}