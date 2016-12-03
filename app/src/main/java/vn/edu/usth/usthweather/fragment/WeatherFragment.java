package vn.edu.usth.usthweather.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import vn.edu.usth.usthweather.R;

/**
 * Created by duy on 11/4/16.
 */

public class WeatherFragment extends Fragment{
    @Override
    public void onStart() {
        super.onStart();
        final ImageView imageView = (ImageView) getActivity().findViewById(R.id.condition_icon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                lp.width = imageView.getWidth()/2;
                lp.height = imageView.getHeight()/2;
                imageView.setLayoutParams(lp);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }
}
