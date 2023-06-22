package com.convert.banner.util;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.HashMap;

public class TypefaceCache {

    private static final TypefaceCache INSTANCE = new TypefaceCache();

    private TypefaceCache() {
    }

    public static TypefaceCache getInstance() {
        return INSTANCE;
    }

    private final HashMap<String, Typeface> mTypefaceMap = new HashMap<>();

    public Typeface getTypeface(AssetManager assetManager, String path) {
        if (mTypefaceMap.containsKey(path)) {
            return mTypefaceMap.get(path);
        }
        Typeface typeface = Typeface.createFromAsset(assetManager, path);
        mTypefaceMap.put(path, typeface);
        return typeface;
    }
}

