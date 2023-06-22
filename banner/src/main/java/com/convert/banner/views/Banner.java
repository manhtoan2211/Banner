package com.convert.banner.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.convert.banner.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.convert.banner.models.BannerItem;
import com.convert.banner.util.AppConfigs;

import java.util.ArrayList;

public class Banner extends CardView {

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
        setCardBackgroundColor(Color.WHITE);
        setRadius(getResources().getDimensionPixelSize(R.dimen.border_layout_setting));
        LinearLayout container = new LinearLayout(getContext());
        container.setOrientation(LinearLayout.VERTICAL);
        addView(container, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        int i = getResources().getDisplayMetrics().widthPixels;
        int i3 = i / 7;
        String data = AppConfigs.getInstance().getString("banner_data", "");
        Log.i("Toan", "banner_data " + data);
        if (!data.isEmpty()) {
            ArrayList<BannerItem> items = new Gson().fromJson(data, new TypeToken<ArrayList<BannerItem>>() {
            }.getType());

            if (!items.isEmpty()) {
                for (BannerItem temp : items) {
                    ViewItem viewItem = new ViewItem(getContext());
                    viewItem.setBannerItem(temp);
                    if (items.indexOf(temp) == 0) {
                        viewItem.setBackgroundTop();
                    } else if (items.indexOf(temp) == items.size() - 1) {
                        viewItem.setBackgroundBottom();
                    }
                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, i3);
                    container.addView(viewItem, lp);
                }
            }

        }
    }
}
