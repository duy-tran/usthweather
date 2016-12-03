package vn.edu.usth.usthweather;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by duy on 12/1/16.
 */

public class CustomAdapter extends BaseAdapter{

    Context context;
    JSONArray forecasts;
    private static LayoutInflater inflater=null;

    public CustomAdapter(Activity activity, JSONArray array) throws JSONException {
        context = activity;
        forecasts = array;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i=0;i<forecasts.length();i++){
            Log.i("JSON TEST --- Item "+i,forecasts.getJSONObject(i).toString());
        }
    }

    @Override
    public int getCount() {
        return forecasts.length();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder {
        TextView day;
        ImageView icon;
        TextView text;
        TextView temp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        View rowView;
        JSONObject obj = null;
        try {
            obj = forecasts.getJSONObject(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        rowView = inflater.inflate(R.layout.item_forecast, null);
        holder.day= (TextView) rowView.findViewById(R.id.forecast_day);
        holder.icon = (ImageView) rowView.findViewById(R.id.forecast_icon);
        holder.text= (TextView) rowView.findViewById(R.id.forecast_text);
        holder.temp = (TextView) rowView.findViewById(R.id.forecast_temp);
        try {
            holder.day.setText(obj.getString("day"));
            holder.icon.setImageResource(context.getResources().getIdentifier("weather_"+obj.getString("code"), "drawable", context.getPackageName()));
            holder.text.setText(obj.getString("text"));
            holder.temp.setText(obj.getString("low")+" - "+obj.getString("high")+"\u2103");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rowView;
    }
}
