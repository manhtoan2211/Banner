package com.convert.banner.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

public class Utils {

    public static void openAppPackage(Context context, String packageName) {
        try {
            if (isAppInstalled(context, packageName)) {
                openAppInstalled(context, packageName);
                return;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            context.startActivity(intent);
        } catch (Exception e) {

        }
    }

    public static boolean isAppInstalled(Context context, String package_name) {
        try {
            PackageManager pm = context.getPackageManager();
            pm.getPackageInfo("" + package_name, PackageManager.GET_META_DATA);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void openAppInstalled(Context context, String packageName) {
        try {
            Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            context.startActivity(launchIntent);
        } catch (Exception e) {

        }
    }
}
