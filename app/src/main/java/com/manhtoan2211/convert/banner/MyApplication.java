package com.manhtoan2211.convert.banner;

import android.app.Application;

import com.convert.banner.util.AppConfigs;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
            AppConfigs.getInstance().setConfig(config);

            FirebaseRemoteConfig.getInstance();
            FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                    .setMinimumFetchIntervalInSeconds(3600)
                    .build();
            config.setConfigSettingsAsync(configSettings);
            config.setDefaultsAsync(com.convert.banner.R.xml.default_data);
            config.fetchAndActivate();
        } catch (Exception e) {
        }
    }
}
