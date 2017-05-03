package com.solarexsoft.disscrollview;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;



public class NestedFrameLayout extends FrameLayout implements DisscrollListener {

    public NestedFrameLayout(@NonNull Context context) {
        super(context);

    }

    public NestedFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public NestedFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int
            defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onDisscroll(float ratio) {

    }

    @Override
    public void onResetDisscroll() {

    }
}
