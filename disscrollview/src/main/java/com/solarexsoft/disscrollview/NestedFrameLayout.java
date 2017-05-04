package com.solarexsoft.disscrollview;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;


public class NestedFrameLayout extends FrameLayout implements DisscrollListener {

    private static final int TRANSLATION_FROM_TOP = 0x01;
    private static final int TRANSLATION_FROM_BOTTOM = 0x02;
    private static final int TRANSLATION_FROM_LEFT = 0x04;
    private static final int TRANSLATION_FROM_RIGHT = 0x08;

    private static ArgbEvaluator sArgbEvaluator = new ArgbEvaluator();

    private int mDisscrollFromBgColor;
    private int mDisscrollToBgColor;
    private boolean mDisscrollAlpha;
    private int mDisscrollTranslation;
    private boolean mDisscrollScaleX;
    private boolean mDisscrollScaleY;
    private int mHeight;
    private int mWidth;

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


    public void setDisscrollFromBgColor(int disscrollFromBgColor) {
        mDisscrollFromBgColor = disscrollFromBgColor;
    }

    public void setDisscrollToBgColor(int disscrollToBgColor) {
        mDisscrollToBgColor = disscrollToBgColor;
    }

    public void setDisscrollAlpha(boolean disscrollAlpha) {
        mDisscrollAlpha = disscrollAlpha;
    }

    public void setDisscrollTranslation(int disscrollTranslation) {
        mDisscrollTranslation = disscrollTranslation;
    }

    public void setDisscrollScaleX(boolean disscrollScaleX) {
        mDisscrollScaleX = disscrollScaleX;
    }

    public void setDisscrollScaleY(boolean disscrollScaleY) {
        mDisscrollScaleY = disscrollScaleY;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    public void onDisscroll(float ratio) {
        //ratio : 0-1
        if (mDisscrollAlpha) {
            setAlpha(ratio);
        }
        if (mDisscrollScaleX) {
            setScaleX(ratio);
        }
        if (mDisscrollScaleY) {
            setScaleY(ratio);
        }
        if (isTranslationFrom(TRANSLATION_FROM_BOTTOM)) {
            setTranslationY(mHeight * (1 - ratio));// mHeight --> 0
        }
        if (isTranslationFrom(TRANSLATION_FROM_TOP)) {
            setTranslationY(-mHeight * (1 - ratio));
        }
        if (isTranslationFrom(TRANSLATION_FROM_LEFT)) {
            setTranslationX(-mWidth * (1 - ratio));
        }
        if (isTranslationFrom(TRANSLATION_FROM_RIGHT)) {
            setTranslationX(mWidth * (1 - ratio));
        }
        if (mDisscrollFromBgColor != -1 && mDisscrollToBgColor != -1) {
            setBackgroundColor((int) sArgbEvaluator.evaluate(ratio, mDisscrollFromBgColor,
                    mDisscrollToBgColor));
        }
    }

    private boolean isTranslationFrom(int translation) {
        if (mDisscrollTranslation == -1) {
            return false;
        }
        boolean result = (mDisscrollTranslation & translation) != 0;
        return result;
    }

    @Override
    public void onResetDisscroll() {
        if (mDisscrollAlpha) {
            setAlpha(1);
        }
        if (mDisscrollScaleX) {
            setScaleX(1);
        }
        if (mDisscrollScaleY) {
            setScaleY(1);
        }
        if (isTranslationFrom(TRANSLATION_FROM_BOTTOM)) {
            setTranslationY(mHeight);
        }
        if (isTranslationFrom(TRANSLATION_FROM_TOP)) {
            setTranslationY(-mHeight);
        }
        if (isTranslationFrom(TRANSLATION_FROM_LEFT)) {
            setTranslationX(-mWidth);
        }
        if (isTranslationFrom(TRANSLATION_FROM_RIGHT)) {
            setTranslationX(mWidth);
        }
    }
}
