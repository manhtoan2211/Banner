package com.convert.banner.views;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.convert.banner.R;
import com.convert.banner.dialog.BannerDialog;
import com.convert.banner.models.BannerItem;
import com.convert.banner.util.ItemCallback;
import com.convert.banner.util.Utils;

public class ViewItem extends RelativeLayout {

    private final ImageView mImApp, mImNext;
    private final CustomTextView tv;
    private final View vDivider;
    private BannerItem bannerItem;
    private ItemCallback mItemCallback;
    private float mIconSize = 0.085f;
    private float mTextSize = 3.8f;
    private float mIconNextSize = 0.017f;
    private int mWidthScreen;

    public ViewItem(Context context) {
        super(context);
        mWidthScreen = getResources().getDisplayMetrics().widthPixels;
        int i2 = mWidthScreen / 25;
        int i3 = mWidthScreen / 7;
        mImApp = new ImageView(context);
        mImNext = new ImageView(context);
        mImApp.setId(123);
        int sizeIm = (int) (mIconSize * mWidthScreen);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(sizeIm, sizeIm);
        layoutParams.setMargins(i2, 0, i2, 0);
        layoutParams.addRule(15);
        addView(mImApp, layoutParams);
        tv = new CustomTextView(context);
        tv.setId(124);
        tv.setSingleLine();
        tv.setEllipsize(TextUtils.TruncateAt.END);
        tv.setTextSize(0, (mWidthScreen * mTextSize) / 100.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(17, mImApp.getId());
        layoutParams2.setMargins(0, 0, i3, 0);
        addView(tv, layoutParams2);
        vDivider = new View(context);
        vDivider.setBackgroundColor(Color.parseColor("#40555555"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams3.setMarginEnd(20);
        layoutParams3.addRule(12);
        layoutParams3.addRule(17, mImApp.getId());
        addView(vDivider, layoutParams3);
        setBackgroundResource(R.drawable.bg_item_main);
        addNext();
    }

    public void setIconSize(float iconSize) {
        mImApp.getLayoutParams().height = (int) (iconSize * mWidthScreen);
        mImApp.getLayoutParams().width = (int) (iconSize * mWidthScreen);
    }

    public void setTextSize (float textSize) {
        tv.setTextSize((mWidthScreen * textSize) / 100.0f);
    }

    public void setIconNextSize(float iconSize) {
        mImNext.getLayoutParams().height = (int) (iconSize * mWidthScreen);
        mImNext.getLayoutParams().width = (int) (iconSize * mWidthScreen);
    }

    public void setItemCallBack(ItemCallback callback) {
        this.mItemCallback = callback;
    }

    public void setBannerItem(BannerItem bannerItem) {
        this.bannerItem = bannerItem;
        if (bannerItem == null
                || bannerItem.appLink == null
                || bannerItem.appName == null
                || bannerItem.packageName == null) {
            return;
        }

        Glide.with(getContext()).load(bannerItem.appLink).into(mImApp);
        tv.setText(bannerItem.appName);
        setOnClickListener(v -> {
            if (bannerItem.packageName != null) {
                if (Utils.isAppInstalled(getContext(), bannerItem.packageName)) {
                    Utils.openAppPackage(getContext(), bannerItem.packageName);
                } else {
                    BannerDialog bannerDialog = new BannerDialog(getContext());
                    bannerDialog.setupItems(bannerItem, mItemCallback);
                }
                if (mItemCallback != null) {
                    mItemCallback.onItemClick(bannerItem.packageName);
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
        int i = mWidthScreen / 25;
        mImNext.setImageResource(R.drawable.ic_next_setting);
        int sizeIm = (int) (mIconNextSize * mWidthScreen);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(sizeIm, sizeIm);
        layoutParams.addRule(21);
        layoutParams.addRule(15);
        layoutParams.setMargins(0, 0, i / 2, 0);
        addView(mImNext, layoutParams);
    }

    public void goneDivider() {
        this.vDivider.setVisibility(GONE);
    }

    public void setTextColor(int color) {
        tv.setTextColor(color);
    }
}

