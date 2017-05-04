package com.solarexsoft.disscrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;


public class DisscrollView extends ScrollView {
    private static final String TAG = "DisscrollView";
    private DisscrollLayout mContent;

    public DisscrollView(Context context) {
        super(context);
    }

    public DisscrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DisscrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mContent = (DisscrollLayout) getChildAt(0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onSizeChanged: w = " + w + ", h = " + h);
        }
        View first = mContent.getChildAt(0);
        first.getLayoutParams().height = getHeight();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        int screenHeight = getHeight();
        for (int i = 0; i < mContent.getChildCount(); i++) {
            View child = mContent.getChildAt(i);
            if (!(child instanceof DisscrollListener)) {
                continue;
            }
            DisscrollListener disscrollListener = (DisscrollListener)child;
            int childTop = child.getTop();
            int childHeight = child.getHeight();
            int absTop = childTop - t;
            if (absTop < screenHeight){
                int visibleGap = screenHeight - absTop;
                float ratio = visibleGap/(float)childHeight;
                disscrollListener.onDisscroll(clamp(ratio, 1.0f, 0f));
            } else {
                disscrollListener.onResetDisscroll();
            }
        }
    }

    private float clamp(float ratio, float max, float min) {
        return Math.max(Math.min(ratio, max), min);
    }
}
