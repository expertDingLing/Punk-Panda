package com.spika.punkpanda.chat.view.roundimage;

import android.content.Context;
import android.util.AttributeSet;

import androidx.core.content.ContextCompat;

public class RoundImageView extends RoundedImageView {

	public RoundImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.setOval(true);
		this.setBorderColor(ContextCompat.getColor(context, android.R.color.white));
		this.setBorderWidth(2.0f);
	}
}
