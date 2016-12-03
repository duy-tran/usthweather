package vn.edu.usth.usthweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import vn.edu.usth.usthweather.CustomAdapter;
import vn.edu.usth.usthweather.R;
import vn.edu.usth.usthweather.Shared;
import vn.edu.usth.usthweather.WeatherActivity;

/**
 * Created by duy on 11/4/16.
 */

public class WeatherAndForecastFragment extends Fragment {
    public WeatherAndForecastFragment() {
        super();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_weatherandforecast, container, false);
        updateInfo();
        return v;
    }

    private void updateInfo() {
        RequestQueue queue = Shared.getInstance().getRequest(getContext());
        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22hanoi%20vietnam%22)%20and%20u%3D'c'&format=json&diagnostics=true&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys&callback=";
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("USTHWeather", "Json response " + response);
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONObject condition = obj.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONObject("condition");
                    ((TextView) getActivity().findViewById(R.id.condition_temp)).setText(condition.getString("temp") + "\u2103");
                    ((TextView) getActivity().findViewById(R.id.condition_text)).setText(condition.getString("text"));
                    ((ImageView) getActivity().findViewById(R.id.condition_icon)).setImageResource(getResources().getIdentifier("weather_" + condition.getString("code"), "drawable", getContext().getPackageName()));
                    JSONArray forecasts = obj.getJSONObject("query").getJSONObject("results").getJSONObject("channel").getJSONObject("item").getJSONArray("forecast");
                    ListView lv = (ListView) getActivity().findViewById(R.id.list_forecast);
                    lv.setAdapter(new CustomAdapter(getActivity(), forecasts));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }

}
