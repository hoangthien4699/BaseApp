package com.example.baseapp.utils;

import android.content.Context;
import android.net.Uri;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ImageUtils {

    private static ImageUtils mInstance;

    public static ImageUtils getInstance() {
        if (mInstance == null) return new ImageUtils();
        return mInstance;
    }

    public void loadImage(Context context, Uri uri, AppCompatImageView imageView) {
        RequestOptions requestOptions = RequestOptions.skipMemoryCacheOf(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(context).load(uri).centerCrop().apply(requestOptions).into(imageView);
    }

    public void loadImage(Context context, int resId, AppCompatImageView imageView) {
        Glide.with(context).load(resId).centerCrop().into(imageView);
    }

    public void loadImage(Context context, String url, AppCompatImageView imageView) {
        RequestOptions requestOptions = RequestOptions.skipMemoryCacheOf(true).diskCacheStrategy(DiskCacheStrategy.NONE);
        Glide.with(context).load(url).centerCrop().apply(requestOptions).into(imageView);
    }
}
