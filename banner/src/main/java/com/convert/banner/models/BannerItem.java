package com.convert.banner.models;

import com.google.gson.annotations.SerializedName;

public class BannerItem {
    @SerializedName("packageName")
    public String packageName;
    @SerializedName("appName")
    public String appName;
    @SerializedName("appLink")
    public String appLink;
    @SerializedName("bannerLink")
    public String bannerLink;

    public BannerItem(String packageName, String appName, String appLink, String bannerLink) {
        this.packageName = packageName;
        this.appName = appName;
        this.appLink = appLink;
        this.bannerLink = bannerLink;
    }
}
