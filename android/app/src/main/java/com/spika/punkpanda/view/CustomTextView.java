package com.spika.punkpanda.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import com.spika.punkpanda.utils.FontsHolder;

public class CustomTextView extends AppCompatTextView {
    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";

    public CustomTextView(Context context) {
        super(context);
        applyCustomFont(context, null);
    }

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        applyCustomFont(context, attributeSet);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        applyCustomFont(context, attributeSet);
    }

    private void applyCustomFont(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            setTypeface(FontsHolder.getInstance(context).getCustomTypeface(), Typeface.NORMAL);
            return;
        }
        setTypeface(FontsHolder.getInstance(context).getCustomTypeface(), attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", 0));
    }
}
