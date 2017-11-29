package com.bolo1.oschina1.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bolo1.oschina1.util.UIUtils;

/**
 * Created by 菠萝 on 2017/11/29.
 */

public class TextFragment extends FrameLayout {
    public TextFragment(@NonNull Context context) {
        super(context);
    }

    public TextFragment(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextFragment(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

 

}
