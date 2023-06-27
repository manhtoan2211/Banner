package com.convert.banner.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.convert.banner.BuildConfig;
import com.convert.banner.R;
import com.convert.banner.util.AppConfigs;
import com.convert.banner.util.ItemCallback;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.convert.banner.models.BannerItem;

import java.util.ArrayList;

public class Banner extends CardView {

    private final ArrayList<ViewItem> mList = new ArrayList<>();
    private LinearLayout mContainer;
    private ItemCallback mItemCallback;

    public Banner(@NonNull Context context) {
        super(context);
        initView();
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public Banner(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setCardElevation(10);
        setRadius(getResources().getDimensionPixelSize(R.dimen.border_layout_setting));
        mContainer = new LinearLayout(getContext());
        mContainer.setOrientation(LinearLayout.VERTICAL);
        addView(mContainer, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

    public void setItemCallback(ItemCallback callback) {
        this.mItemCallback = callback;
        loaData();
    }

    public void bindData(ArrayList<BannerItem> items) {
        if (items == null || items.isEmpty()) return;
        mList.clear();
        int i = getResources().getDisplayMetrics().widthPixels;
        int i3 = i / 7;
        for (BannerItem temp : items) {
            ViewItem viewItem = new ViewItem(getContext());
            viewItem.setItemCallBack(mItemCallback);
            viewItem.setBannerItem(temp);
            if (items.indexOf(temp) == 0) {
                viewItem.setBackgroundTop();
            } else if (items.indexOf(temp) == items.size() - 1) {
                viewItem.setBackgroundBottom();
            }
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, i3);
            mContainer.addView(viewItem, lp);
            mList.add(viewItem);
        }
        changeBackground(false);
    }

    public void loaData() {
        String jsonData = AppConfigs.getInstance().getString("banner_data", "");
        ArrayList<BannerItem> items = new Gson().fromJson(jsonData, new TypeToken<ArrayList<BannerItem>>() {
        }.getType());
        bindData(items);
    }

    public void changeBackground(boolean isDarkMode) {
        if (isDarkMode) {
            setCardBackgroundColor(Color.BLACK);
            for (ViewItem viewItem : mList) {
                viewItem.setTextColor(Color.WHITE);
            }
        } else {
            setCardBackgroundColor(Color.WHITE);
            for (ViewItem viewItem : mList) {
                viewItem.setTextColor(Color.BLACK);
            }
        }
    }
}
