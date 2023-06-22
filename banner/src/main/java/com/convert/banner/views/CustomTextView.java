package com.convert.banner.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.convert.banner.util.TypefaceCache;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {

    public CustomTextView(@NonNull Context context) {
        super(context);
        setTypeface(TypefaceCache.getInstance().getTypeface(context.getAssets(), "fonts/SFProDisplay.otf"));
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTypeface(TypefaceCache.getInstance().getTypeface(context.getAssets(), "fonts/SFProDisplay.otf"));
    }

    public CustomTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(TypefaceCache.getInstance().getTypeface(context.getAssets(), "fonts/SFProDisplay.otf"));
    }
}
