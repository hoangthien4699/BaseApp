package com.example.baseapp.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.baseapp.R;

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getView() != null) {
            ((ViewGroup) getView().getParent()).removeView(getView());
        }
        return getFragmentView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        configureDataIfNeed();
    }

    protected void replaceCurrentFragment(Fragment fragment) {
        requireActivity().getSupportFragmentManager().popBackStack();
        openFragment(fragment);
    }

    protected void replaceCurrentFragment(int containId, Fragment fragment) {
        requireActivity().getSupportFragmentManager().popBackStack();
        openFragment(containId, fragment);
    }

    protected void openFragment(Fragment fragment) {
        if (!this.isAdded()) {
            return;
        }

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.stay, R.anim.stay, R.anim.exit_to_right);
        transaction.add(R.id.home_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    protected void openFragment(int containId, Fragment fragment) {
        if (!this.isAdded()) {
            return;
        }

        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.stay, R.anim.stay, R.anim.exit_to_right);
        transaction.add(containId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    protected void openFragmentOnActivity(Fragment fragment, Intent intent) {
        if (!this.isAdded()) {
            return;
        }

        startActivity(intent);
    }

    public abstract View getFragmentView();

    public abstract void configureDataIfNeed();
}
