package com.manhtoan2211.convert.banner;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            FirebaseApp.initializeApp(this);
            FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
            FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                    .setMinimumFetchIntervalInSeconds(3600)
                    .build();
            config.setConfigSettingsAsync(configSettings);
            config.setDefaultsAsync(R.xml.default_data);
            config.fetchAndActivate();
        } catch (Exception e) {

        }
    }
}
