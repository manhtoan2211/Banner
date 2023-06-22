package com.convert.banner.util;

import android.util.Log;

import com.convert.banner.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class AppConfigs {

    private static AppConfigs _instance;
    private FirebaseRemoteConfig config;

    private AppConfigs() {

    }

    public FirebaseRemoteConfig getConfig() {
        if (this.config == null) {
            try {
                FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();

                FirebaseRemoteConfig.getInstance();
                FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                        .setMinimumFetchIntervalInSeconds(3600)
                        .build();
                config.setConfigSettingsAsync(configSettings);
                config.setDefaultsAsync(R.xml.default_data);
                config.fetchAndActivate();
                this.config = config;
            } catch (Exception e) {
                Log.e("AppConfigs", "getConfigs: init firebase config error " + e);
            }
        }
        return this.config;
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return getConfig() == null ? defaultValue : getConfig().getBoolean(key);
    }

    public String getString(String key, String defaultValue) {
        return getConfig() == null ? defaultValue : getConfig().getString(key);
    }

    public long getLong(String key, long defaultValue) {
        return getConfig() == null ? defaultValue : getConfig().getLong(key);
    }

    public void setConfig(FirebaseRemoteConfig config) {
        this.config = config;
    }

    public static AppConfigs getInstance() {
        if (_instance == null) {
            _instance = new AppConfigs();
        }
        return _instance;
    }
}

