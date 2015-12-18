package webService;

import android.app.Application;
import android.graphics.Bitmap;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by arafla on 15/12/2015.
 */
public class FormationApplication extends Application {
    private RequestQueue mVolleyRequestQueue;
    private ImageLoader mVolleyImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        // On initialise notre Thread-Pool et notre ImageLoader
        mVolleyRequestQueue = Volley.newRequestQueue(getApplicationContext());
        mVolleyImageLoader = new ImageLoader(mVolleyRequestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return null;
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

            }
        });
        mVolleyRequestQueue.start();
    }

    public RequestQueue getVolleyRequestQueue() {
        return mVolleyRequestQueue;
    }

    public ImageLoader getVolleyImageLoader() {
        return mVolleyImageLoader;
    }

    @Override
    public void onTerminate() {
        mVolleyRequestQueue.stop();
        super.onTerminate();
    }
}
