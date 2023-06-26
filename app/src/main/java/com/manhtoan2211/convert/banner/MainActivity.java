package com.manhtoan2211.convert.banner;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.convert.banner.util.ItemCallback;
import com.convert.banner.views.Banner;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // case 1 add in XML
        ((Banner) findViewById(R.id.banner)).setItemCallback(new ItemCallback() {
            @Override
            public void onItemClick(String packageName) {
                Log.i("MainActivity", "onItemClick");
                //TODO something
            }

            @Override
            public void onItemClickInDialog(String packageName) {
                Log.i("MainActivity", "onItemClickInDialog");
                //TODO something
            }
        });

        // case 2 add in Program
        Banner banner = new Banner(this);
        banner.setItemCallback(new ItemCallback() {
            @Override
            public void onItemClick(String packageName) {
                Log.i("MainActivity", "onItemClick");
                //TODO something
            }

            @Override
            public void onItemClickInDialog(String packageName) {
                Log.i("MainActivity", "onItemClickInDialog");
                //TODO something
            }
        });
        ((FrameLayout)findViewById(R.id.bannerContainer)).addView(banner, FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
    }
}