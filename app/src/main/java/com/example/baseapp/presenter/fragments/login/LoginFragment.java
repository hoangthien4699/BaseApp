package com.example.baseapp.presenter.fragments.login;

import android.os.Bundle;
import android.view.View;

import com.example.baseapp.presenter.fragments.base.BaseFragment;
import com.example.baseapp.view.login.LoginView;

public class LoginFragment extends BaseFragment {
    private LoginView mView;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View getFragmentView() {
        mView = new LoginView(requireContext());
        return mView;
    }

    @Override
    public void configureDataIfNeed() {

    }
}
