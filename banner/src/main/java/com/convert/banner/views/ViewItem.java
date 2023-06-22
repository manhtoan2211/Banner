package com.convert.banner.views;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.convert.banner.R;
import com.convert.banner.dialog.BannerDialog;
import com.convert.banner.models.BannerItem;
import com.convert.banner.util.Utils;

public class ViewItem extends RelativeLayout {

    private final ImageView im;
    private final TextView tv;
    private final View vDivider;
    private BannerItem bannerItem;

    public ViewItem(Context context) {
        super(context);
        int i = getResources().getDisplayMetrics().widthPixels;
        int i2 = i / 25;
        int i3 = i / 7;
        im = new ImageView(context);
        im.setId(123);
        int i4 = i3 - ((i2 * 3) / 2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i4, i4);
        layoutParams.setMargins(i2, 0, i2, 0);
        layoutParams.addRule(15);
        addView(im, layoutParams);
        tv = new TextView(context);
        tv.setId(124);
        tv.setSingleLine();
        tv.setEllipsize(TextUtils.TruncateAt.END);
        tv.setTextSize(0, (i * 3.8f) / 100.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(17, im.getId());
        layoutParams2.setMargins(0, 0, i3, 0);
        addView(tv, layoutParams2);
        vDivider = new View(context);
        vDivider.setBackgroundColor(Color.parseColor("#40555555"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams3.setMarginEnd(20);
        layoutParams3.addRule(12);
        layoutParams3.addRule(17, im.getId());
        addView(vDivider, layoutParams3);
        setBackgroundResource(R.drawable.bg_item_main);
        addNext();
    }

    public void setBannerItem(BannerItem bannerItem) {
        this.bannerItem = bannerItem;
        if (bannerItem == null
                || bannerItem.appLink == null
                || bannerItem.appName == null
                || bannerItem.packageName == null) {
            return;
        }

        Glide.with(getContext()).load(bannerItem.appLink).into(im);
        tv.setText(bannerItem.appName);
        setOnClickListener(v -> {
            if (bannerItem.packageName != null) {
                if (Utils.isAppInstalled(getContext(), bannerItem.packageName)) {
                    Utils.openAppPackage(getContext(), bannerItem.packageName);
                } else {
                    BannerDialog bannerDialog = new BannerDialog(getContext());
                    bannerDialog.setupItems(bannerItem);
                }
            }
        });
    }

    public void setBackgroundTop() {
        setBackgroundResource(R.drawable.bg_item_top);
    }

    public void setBackgroundBottom() {
        setBackgroundResource(R.drawable.bg_item_bottom);
        goneDivider();
    }

    public void addNext() {
        int i = getResources().getDisplayMetrics().widthPixels / 25;
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ic_next_setting);
        int i2 = (i * 2) / 3;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i2);
        layoutParams.addRule(21);
        layoutParams.addRule(15);
        layoutParams.setMargins(0, 0, i / 2, 0);
        addView(imageView, layoutParams);
    }

    public void goneDivider() {
        this.vDivider.setVisibility(GONE);
    }
}

