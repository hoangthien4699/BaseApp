package com.example.baseapp.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baseapp.R;

public abstract class BaseView extends FrameLayout {

    private Context mContext;
    private FrameLayout mLayoutLoading;

    public BaseView(@NonNull Context context) {
        super(context);
        mContext = context;
        addViewFromLayout(mContext);
        initElementLayouts();
        mLayoutLoading = findViewById(R.id.view_loading);
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        addViewFromLayout(mContext);
        initElementLayouts();
    }

    public BaseView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        addViewFromLayout(mContext);
        initElementLayouts();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setEvent();
        setValue();
        configHeaderBar();
    }

    public void setLoading(int visibility) {
        if (mLayoutLoading != null) {
            mLayoutLoading.setVisibility(visibility);
        }
    }

    private void addViewFromLayout(Context context) {
        View view = LayoutInflater.from(context).inflate(getViewLayout(), null);
        addView(view);
    }

    public abstract int getViewLayout();

    public abstract void initElementLayouts();

    public abstract void setValue();

    public abstract void setEvent();

    public abstract void configHeaderBar();
}
