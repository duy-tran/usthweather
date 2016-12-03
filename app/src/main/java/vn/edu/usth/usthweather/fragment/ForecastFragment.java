package vn.edu.usth.usthweather.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import vn.edu.usth.usthweather.R;
import vn.edu.usth.usthweather.Shared;

/**
 * Created by duy on 10/25/16.
 */

public class ForecastFragment  extends Fragment {
    public ForecastFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);

//        RequestQueue queue = Shared.getInstance().getRequest(getContext());
//
//        Response.Listener<Bitmap> listener = new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap response) {
//                ImageView iv = (ImageView)  getActivity().findViewById(R.id.background_forecast);
//                iv.setImageBitmap(response);
//            }
//        };
//        ImageRequest imageRequest = new ImageRequest( "http://ict.usth.edu.vn/wp-content/uploads/usth/usthlogo.png", listener, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.ARGB_8888,null);
//        queue.add(imageRequest);
        return v;
    }
}
