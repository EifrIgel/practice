package com.example.crush.marqueetextview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by crush on 7/13/15.
 */
public class MarqueeText extends TextView{
    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attrs, int defstyle) {
        super(context, attrs, defstyle);
    }
    public MarqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
