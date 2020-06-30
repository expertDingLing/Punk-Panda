package com.spika.punkpanda.utils;

import android.content.Context;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

import com.spika.punkpanda.R;

public class FontsHolder {
    private static FontsHolder instance;
    private Typeface customTypeface;

    public static FontsHolder getInstance(Context context) {
        if (instance == null) {
            instance = new FontsHolder();
            instance.init(context);
        }
        return instance;
    }

    private void init(Context context) {
        this.customTypeface = ResourcesCompat.getFont(context, R.font.lato);
    }

    public Typeface getCustomTypeface() {
        return this.customTypeface;
    }
}
