package com.solarexsoft.disscrollview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class DisscrollLayout extends LinearLayout {
    public DisscrollLayout(Context context) {
        super(context);
    }

    public DisscrollLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DisscrollLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new SolarexLayoutParams(getContext(), attrs);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        SolarexLayoutParams slp = (SolarexLayoutParams) params;
        if (!slp.isDisscrollAble()) {
            super.addView(child, index, params);
        } else {
            NestedFrameLayout nestedFrameLayout = new NestedFrameLayout(getContext());
            nestedFrameLayout.setDisscrollAlpha(slp.mDisscrollAlpha);
            nestedFrameLayout.setDisscrollScaleX(slp.mDisscrollScaleX);
            nestedFrameLayout.setDisscrollScaleY(slp.mDisscrollScaleY);
            nestedFrameLayout.setDisscrollFromBgColor(slp.mDisscrollFromBgColor);
            nestedFrameLayout.setDisscrollToBgColor(slp.mDisscrollToBgColor);
            nestedFrameLayout.setDisscrollTranslation(slp.mDisscrollTranslation);
            nestedFrameLayout.addView(child);
            super.addView(nestedFrameLayout, index, params);
        }
    }

    public static class SolarexLayoutParams extends LinearLayout.LayoutParams {
        public int mDisscrollFromBgColor;
        public int mDisscrollToBgColor;
        public int mDisscrollTranslation;
        public boolean mDisscrollAlpha;
        public boolean mDisscrollScaleX;
        public boolean mDisscrollScaleY;

        public SolarexLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray typedArray = c.obtainStyledAttributes(attrs, R.styleable
                    .DisscrollView_LayoutParams);
            mDisscrollAlpha = typedArray.getBoolean(R.styleable
                    .DisscrollView_LayoutParams_disscroll_alpha, false);
            mDisscrollScaleX = typedArray.getBoolean(R.styleable
                    .DisscrollView_LayoutParams_disscroll_scaleX, false);
            mDisscrollScaleY = typedArray.getBoolean(R.styleable
                    .DisscrollView_LayoutParams_disscroll_scaleY, false);
            mDisscrollFromBgColor = typedArray.getInt(R.styleable
                    .DisscrollView_LayoutParams_disscroll_fromBgColor, -1);
            mDisscrollToBgColor = typedArray.getInt(R.styleable
                    .DisscrollView_LayoutParams_disscroll_toBgColor, -1);
            mDisscrollTranslation = typedArray.getInt(R.styleable
                    .DisscrollView_LayoutParams_disscroll_translation, -1);
        }

        public boolean isDisscrollAble() {
            return mDisscrollAlpha || mDisscrollScaleX || mDisscrollScaleY ||
                    (mDisscrollFromBgColor != -1) || (mDisscrollToBgColor != -1) ||
                    (mDisscrollTranslation != -1);
        }
    }
}
