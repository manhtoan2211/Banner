package com.convert.banner.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.convert.banner.R;
import com.convert.banner.models.BannerItem;
import com.convert.banner.util.ItemCallback;
import com.convert.banner.util.Utils;

public class BannerDialog extends Dialog {

    public BannerDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.banner_dialog);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public BannerDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.banner_dialog);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    protected BannerDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        setContentView(R.layout.banner_dialog);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void setupItems(BannerItem item, ItemCallback itemCallback) {
        if (item == null) return;
        ((TextView) findViewById(R.id.title)).setText(getContext().getString(R.string.dialog_title, item.appName));
        Glide.with(getContext()).load(item.bannerLink).into((ImageView) findViewById(R.id.bannerImage));
        findViewById(R.id.continue_button).setOnClickListener(v -> {
            Utils.openAppPackage(getContext(), item.packageName);
            if (itemCallback != null) {
                itemCallback.onItemClickInDialog(item.packageName);
            }
        });
        findViewById(R.id.cancel_button).setOnClickListener(v -> {
            dismiss();
        });
        show();
    }
}
