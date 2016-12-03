package vn.edu.usth.usthweather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import vn.edu.usth.usthweather.fragment.ForecastFragment;
import vn.edu.usth.usthweather.fragment.WeatherAndForecastFragment;

public class WeatherActivity extends AppCompatActivity {

    Handler handler;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weather","Destroyed :'(");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weather","App stopped !");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        Log.i("Weather","CREATED *****");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather","Started !!!!!");
        InputStream is = this.getResources()
                .openRawResource(R.raw.datstick);
//        try {
//            Log.i("File","TRY!");
//            File file = new File(Environment
//                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "test.mp3");
//            FileOutputStream os = new FileOutputStream(file);
//            byte[] buf = new byte[8192];
//            int c = 0;
//            while ((c = is.read(buf)) > 0) {
//                os.write(buf, 0, c);
//            }
//            is.close();
//            os.close();
//
//            Log.i("File","Written!");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.wedemboyz);
//        mediaPlayer.start();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Weather","Resumed =====");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i("Weather","Paused ///");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                AsyncTask<Void, Integer, Void> task = new AsyncTask<Void, Integer, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void voids){
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_LONG).show();
                    }
                };
                task.execute();
                return true;
            case R.id.action_settings:
                Intent myIntent = new Intent(this, PrefActivity.class);
                this.startActivity(myIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String titles[] = new String[] { "Hanoi", "Paris", "Toulouse" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT; // number of pages for a ViewPager
        }
        @Override
        public Fragment getItem(int page) {
            // returns an instance of Fragment corresponding to the specified page
//            switch (page) {
//                case 0: return new WeatherAndForecastFragment();
//                case 1: return new WeatherAndForecastFragment();
//                case 2: return new WeatherAndForecastFragment();
//            }
            return new WeatherAndForecastFragment(); // failsafe
        }
        @Override
        public CharSequence getPageTitle(int page) {
            // returns a tab title corresponding to the specified page
            return titles[page];
        }
    }
}
