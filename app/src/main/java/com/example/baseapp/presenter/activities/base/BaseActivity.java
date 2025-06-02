package com.example.baseapp.presenter.activities.base;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.qunlbnhngpate.R;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "api_error";
    private final boolean checkPermission = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getActivityView());
        setValue();
    }

    public abstract View getActivityView();

    public abstract void setValue();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void openFragment(int containId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(containId, fragment);
        transaction.commitAllowingStateLoss();
    }

    public void addFragment(int containId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.stay, R.anim.stay, R.anim.exit_to_right);
        transaction.add(containId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    protected void openOnlyForMessage(Fragment fragment) {
        if (getSupportFragmentManager().isDestroyed()) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.stay, R.anim.stay, R.anim.exit_to_right);
        transaction.replace(R.id.home_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    protected void popAllHomeContainer() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.home_container);
        if (fragment != null) {
            fragment.getParentFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public void addFragmentByTag(int idContainter, Fragment fragment, boolean addToBackstack, String tag) {
        FragmentTransaction transaction = getSupportFragmentManager()
            .beginTransaction();
        transaction.add(idContainter, fragment, tag);
        if (addToBackstack)
            transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public void replaceFragment(int id, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.stay, R.anim.stay, R.anim.exit_to_right);
        transaction.replace(id, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
    }
}
