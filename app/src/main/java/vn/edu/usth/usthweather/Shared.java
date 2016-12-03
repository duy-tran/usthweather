package vn.edu.usth.usthweather;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by duy on 11/29/16.
 */

public class Shared {
    private static Shared instance;
    private RequestQueue queue;

    public static Shared getInstance(){
        if (instance == null) {
            instance = new Shared();
        }
        return instance;
    }

    public RequestQueue getRequest(Context context) {
        if (queue == null)
            queue = Volley.newRequestQueue(context);
        return queue;
    }
}
