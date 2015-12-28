package com.profileapp.arafla.profileapp;

import android.graphics.Bitmap;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by arafla on 15/12/2015.
 */
public class BitmapLruCache implements ImageLoader.ImageCache {
    @Override
    public Bitmap getBitmap(String url) {
        return null;
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {

    }
}
