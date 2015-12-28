package com.profileapp.arafla.profileapp;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by arafla on 22/12/2015.
 */
public class AppController extends Application {
    private static AppController newInstance = new AppController();

    private RequestQueue mVolleyRequestQueue;
    private ImageLoader mVolleyImageLoader;

    /*
        public static AppController getInstance() {
            return newInstance;
        }*/
    public AppController() {


    }

    @Override
    public void onCreate() {
        super.onCreate();

        mVolleyRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mVolleyImageLoader = new ImageLoader(mVolleyRequestQueue, new BitmapLruCache());
        mVolleyRequestQueue.start();
    }

    public RequestQueue getVolleyRequestQueue() {
        return mVolleyRequestQueue;
    }

    public ImageLoader getVolleyImageLoader(Context context) {
        mVolleyRequestQueue = Volley.newRequestQueue(context);
        mVolleyImageLoader = new ImageLoader(mVolleyRequestQueue, new BitmapLruCache());
        mVolleyRequestQueue.start();
        return mVolleyImageLoader;
    }

    @Override
    public void onTerminate() {
        mVolleyRequestQueue.stop();
        super.onTerminate();
    }
}
